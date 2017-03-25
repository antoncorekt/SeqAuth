package com.kozlovsky.common.controller;

import com.kozlovsky.common.email.EmailModel;
import com.kozlovsky.common.email.EmailService;
import com.kozlovsky.user.model.User;
import com.kozlovsky.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anton
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    protected static final String VIEW_NAME_HOMEPAGE = "index";


    @Autowired
    private UserService service;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView showHomePage(Principal principal) {
        ModelAndView model = new ModelAndView(VIEW_NAME_HOMEPAGE);
        LOGGER.info("Render homepage. " + principal.getName());
        try {

            User user = service.getUserForEmail(principal.getName());
            model.addObject("lists", user.getAcc());

        }
        catch (Exception e){
            LOGGER.error(e.toString() + " error");
        }

        return model;
    }
}
