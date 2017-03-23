package com.kozlovsky.common.controller;

import com.kozlovsky.common.email.EmailModel;
import com.kozlovsky.common.email.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
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
    private EmailService emailService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showHomePage() {
        LOGGER.debug("Rendering homepage.");

       /* EmailModel emailModel = new EmailModel();
        Map<String, Object> model = new HashMap<>();
        model.put("from", "kozlovsky.anton@gmail.com");
        model.put("subject", "Hello from " + emailModel.getName() + "!");
        model.put("to", "kozlovsky.anton@gmail.com");
        model.put("ccList", new ArrayList<>());
        model.put("bccList", new ArrayList<>());
        model.put("userName", "javastudyUser");
        model.put("urljavastudy", "javastudy.ru");
        model.put("message", "messageLOlol");
        boolean result = emailService.sendEmail("WEB-INF/email-temp/registered.vm", model);*/



        return VIEW_NAME_HOMEPAGE;
    }
}
