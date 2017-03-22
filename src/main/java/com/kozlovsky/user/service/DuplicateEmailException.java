package com.kozlovsky.user.service;

/**
 * @author anton
 */
public class DuplicateEmailException extends Exception {

    public DuplicateEmailException(String message) {
        super(message);
    }
}
