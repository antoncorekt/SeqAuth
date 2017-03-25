package com.kozlovsky.security.service;

import com.kozlovsky.common.helper.IpProvider;
import com.kozlovsky.security.dto.ExampleUserDetails;
import com.kozlovsky.user.model.SigninEnity;
import com.kozlovsky.user.model.User;
import com.kozlovsky.user.repository.SinginRepository;
import com.kozlovsky.user.repository.UserRepository;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anton
 */
public class RepositoryUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryUserDetailsService.class);

    private UserRepository repository;

    @Autowired
    private SinginRepository singinRepository;

    @Autowired
    public RepositoryUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private IpProvider ipProvider;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("Loading user by username: {}", username);

        User user = repository.findByEmail(username);
        LOGGER.debug("Found user: {}", user);

        if (user == null || (!user.getEnaeble().equals("accept") && !user.getSignInProvider().toString().equals("FACEBOOK"))) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }

        ExampleUserDetails principal = ExampleUserDetails.getBuilder()
                .firstName(user.getFirstName())
                .id(user.getId())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .role(user.getRole())
                .socialSignInProvider(user.getSignInProvider())
                .username(user.getEmail())
                .build();

        LOGGER.debug("Returning user details: {}", principal);


        SigninEnity signinEnity = new SigninEnity(DateTime.now(),ipProvider.getIp() != null ? ipProvider.getIp() : "ip not found");


        signinEnity.setUser(user);

        try {
            singinRepository.save(signinEnity);


            User res = new User();

            List<SigninEnity> singList = user.getAcc();

            if (singList == null) singList = new ArrayList<>();

            singList.add(signinEnity);

            user.setAcc(singList);

            LOGGER.debug("Persisting new user with information: {}", user);
            //res = repository.save(registered);
        }
        catch (Exception e){
            LOGGER.error("Error" + e.getMessage());
        }


        return principal;
    }
}
