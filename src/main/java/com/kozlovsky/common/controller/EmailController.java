package com.kozlovsky.common.controller;

import com.kozlovsky.security.controller.LoginController;
import com.kozlovsky.user.model.User;
import com.kozlovsky.user.service.RepositoryUserService;
import com.kozlovsky.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by anton on 23.03.17.
 */
@Controller
public class EmailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private static final String VIEW_NAME_LOGIN_PAGE = "user/login";

    @Autowired
    private UserService repositoryUserService;

    @RequestMapping(value = "/activations", method = RequestMethod.GET)
    public String emailAccept(@RequestParam("key") String key){

        User user = repositoryUserService.getUserForRegKey(key);


        LOGGER.info("activations request " + key);

        if (user==null){

            LOGGER.info("user in nulllllll ");

            return VIEW_NAME_LOGIN_PAGE;
        }

       // result.addError(new ObjectError("Complete", "Activations complete"));
        repositoryUserService.setEnableForUserActivations(key);

        return "index";
    }

}
