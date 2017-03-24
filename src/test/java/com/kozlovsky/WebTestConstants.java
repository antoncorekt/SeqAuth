package com.kozlovsky;


import com.kozlovsky.user.model.SigninEnity;
import com.kozlovsky.user.model.User;
import com.kozlovsky.user.repository.UserRepository;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class WebTestConstants {

    public static final String FORM_FIELD_EMAIL = "email";
    public static final String FORM_FIELD_FIRST_NAME = "firstName";
    public static final String FORM_FIELD_LAST_NAME = "lastName";
    public static final String FORM_FIELD_PASSWORD = "password";
    public static final String FORM_FIELD_PASSWORD_VERIFICATION = "passwordVerification";
    public static final String FORM_FIELD_SIGN_IN_PROVIDER = "signInProvider";

    public static final String MODEL_ATTRIBUTE_USER_FORM = "user";
    public static final String SESSION_ATTRIBUTE_USER_FORM = "user";

    private WebTestConstants() {}


}
