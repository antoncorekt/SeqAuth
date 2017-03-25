package com.kozlovsky.user.service;

import com.kozlovsky.user.model.SigninEnity;
import com.kozlovsky.user.model.User;
import com.kozlovsky.user.dto.RegistrationForm;
import com.kozlovsky.user.repository.SinginRepository;
import com.kozlovsky.user.repository.UserRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


/**
 * @author anton
 */
@Service
public class RepositoryUserService implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryUserService.class);

    private PasswordEncoder passwordEncoder;

    private UserRepository repository;

    @Autowired
    private SinginRepository singinRepository;

    @Autowired
    public RepositoryUserService(PasswordEncoder passwordEncoder, UserRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }


    @Override
    public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException {
        LOGGER.debug("Registering new user account with information: {}", userAccountData);

        if (emailExist(userAccountData.getEmail())) {
            LOGGER.debug("Email: {} exists. Throwing exception.", userAccountData.getEmail());
            throw new DuplicateEmailException("The email address: " + userAccountData.getEmail() + " is already in use.");
        }

        LOGGER.debug("Email: {} does not exist. Continuing registration.", userAccountData.getEmail());

        String encodedPassword = encodePassword(userAccountData);


        User.Builder user = User.getBuilder()
                .email(userAccountData.getEmail())
                .firstName(userAccountData.getFirstName())
                .lastName(userAccountData.getLastName())
                .password(encodedPassword)
                .enaeble(userAccountData.isSocialSignIn() ? "accept" :"not accept")
                .registerkey(UUID.randomUUID().toString());


        if (userAccountData.isSocialSignIn()) {
            user.signInProvider(userAccountData.getSignInProvider());
        }


        User registered = user.build();



       /* SigninEnity signinEnity = new SigninEnity(DateTime.now(),"lololol1");


        signinEnity.setUser(registered);

        try {
            singinRepository.save(signinEnity);

        }
        catch (Exception e){
            LOGGER.error("Error" + e.getMessage());
        }

        User res = new User();
        try {
            registered.setAcc(Arrays.asList(signinEnity));

            LOGGER.debug("Persisting new user with information: {}", registered);
            //res = repository.save(registered);
        }
        catch (Exception e){
            LOGGER.error("Error" + e.getMessage());
        }*/


        return  repository.save(registered);
    }



    private boolean emailExist(String email) {
        LOGGER.debug("Checking if email {} is already found from the database.", email);

        User user = repository.findByEmail(email);

        if (user != null) {
            LOGGER.debug("User account: {} found with email: {}. Returning true.", user, email);
            return true;
        }

        LOGGER.debug("No user account found with email: {}. Returning false.", email);

        return false;
    }

    public void setEnableForUserActivations(String key){

        LOGGER.debug("Before enable for key: {}. User {}", key, repository.findByRegisterkey(key));

        User user = repository.findByRegisterkey(key);
        repository.delete(user);
        user.setEnaeble("accept");
        repository.save(user);

        LOGGER.debug("After enable for key: {}. User {}", key, repository.findByRegisterkey(key));
    }

    public User getUserForRegKey(String key){
        User user = repository.findByRegisterkey(key);



        LOGGER.debug("Find user for registrations key: {}. Finding {}", key, user);
        return user;
    }

    @Override
    public User getUserForEmail(String email) {
        return repository.findByEmail(email);
    }


    private String encodePassword(RegistrationForm dto) {
        String encodedPassword = null;

        if (dto.isNormalRegistration()) {
            LOGGER.debug("Registration is normal registration. Encoding password.");
            encodedPassword = passwordEncoder.encode(dto.getPassword());
        }

        return encodedPassword;
    }
}
