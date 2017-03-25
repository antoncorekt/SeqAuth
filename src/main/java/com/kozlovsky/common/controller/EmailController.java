package com.kozlovsky.common.controller;

import com.kozlovsky.security.controller.LoginController;
import com.kozlovsky.security.util.SecurityUtil;
import com.kozlovsky.user.model.User;
import com.kozlovsky.user.service.RepositoryUserService;
import com.kozlovsky.user.service.UserService;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public ModelAndView emailAccept(@RequestParam("key") String key, WebRequest request, HttpServletRequest hreq,HttpServletResponse response) throws IOException, ServletException{

        User user = repositoryUserService.getUserForRegKey(key);
        ModelAndView model = new ModelAndView("redirect:/");

        LOGGER.info("activations request " + key);

        if (user==null){

            LOGGER.info("user in nulllllll ");

            return new ModelAndView(VIEW_NAME_LOGIN_PAGE);
        }

       // result.addError(new ObjectError("Complete", "Activations complete"));
        repositoryUserService.setEnableForUserActivations(key);

        hreq.setAttribute("mess", "t");

        try {

        }
        catch (Exception e) {
            hreq.getRequestDispatcher("redirect:/").forward(hreq, response);
        }

        model.addObject("mess","t");
       // SecurityUtil.logInUser(user);
        LOGGER.debug("User {} has been signed in", user);
        //If the user is signing in by using a social provider, this method call stores
        //the connection to the UserConnection table. Otherwise, this method does not
        //do anything.
       // ProviderSignInUtils.handlePostSignUp(user.getEmail(), request);

        return model;
    }

}
