package com.kozlovsky.security.controller;

import com.kozlovsky.user.service.RepositoryUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Petri Kainulainen
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private static final String VIEW_NAME_LOGIN_PAGE = "user/login";

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        LOGGER.debug("Rendering login page.");
        return VIEW_NAME_LOGIN_PAGE;
    }

}
