package com.kozlovsky.user.service;

import com.kozlovsky.user.model.User;
import com.kozlovsky.user.dto.RegistrationForm;

/**
 * @author anton
 */
public interface UserService {

    public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException;

    public void setEnableForUserActivations(String key);


    public User getUserForRegKey(String key);
    public User getUserForEmail(String email);


}
