package com.kozlovsky.security.controller;

import com.kozlovsky.common.helper.IpProvider;
import com.kozlovsky.user.service.RepositoryUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Petri Kainulainen
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    private static final String VIEW_NAME_LOGIN_PAGE = "user/login";

    @Autowired
    private IpProvider ipProvider;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage( HttpServletRequest htppRequest) {
        LOGGER.debug("Rendering login page.");

        ipProvider.setIp(htppRequest.getRemoteAddr());

        return VIEW_NAME_LOGIN_PAGE;
    }

}
