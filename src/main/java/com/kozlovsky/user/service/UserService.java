package com.kozlovsky.user.service;

import com.kozlovsky.user.model.User;
import com.kozlovsky.user.dto.RegistrationForm;

/**
 * @author anton
 */
public interface UserService {

    /**
     * Creates a new user account to the service.
     * @param userAccountData   The information of the created user account.
     * @return  The information of the created user account.
     * @throws DuplicateEmailException Thrown when the email address is found from the database.
     */
    public User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException;
}