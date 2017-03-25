package com.kozlovsky.common.controller;

import com.kozlovsky.common.response.provider.*;
import com.kozlovsky.common.rsa.Rsa;
import com.kozlovsky.common.rsa.RsaRepository;
import com.kozlovsky.security.controller.LoginController;
import com.kozlovsky.user.model.User;
import com.kozlovsky.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;

/**
 * Created by anton on 25.03.17.
 */
@RestController
public class RsaConroller {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService repositoryUserService;

    @Autowired
    private RsaRepository rsaRepository;

    @RequestMapping(value = "rsa/getkey", method = RequestMethod.GET, produces = "application/json")
    public ResponseData getPublic(@RequestParam("user") String email, Principal principal){

        try{
        User user = repositoryUserService.getUserForEmail(email);

        if (user==null){
            return new ErrorResponse("user not found ");
        }

        Rsa rsa;
        if (rsaRepository.isHaveRsa(user.getEmail()))
            rsa = rsaRepository.getRsa(user.getEmail());
        else
            rsa = rsaRepository.addRsa(user.getEmail());

       if (principal!=null)
            return new PublicKeyResponse( rsa.getPublicKey().toString(),rsa.getN().toString());
       else
           return new ErrorResponse("access denied ");
        }
        catch (Exception e){
            return new ErrorResponse(e.toString());
        }
    }

    @RequestMapping(value = "rsa/encrypt", method = RequestMethod.GET, produces = "application/json")
    public ResponseData getEncrypt(@RequestParam("text") String text, @RequestParam("user") String email, Principal principal){

        try{
             User user = repositoryUserService.getUserForEmail(email);

            if (user==null){
                return new ErrorResponse("user not found ");
            }

            Rsa rsa;
            if (rsaRepository.isHaveRsa(user.getEmail()))
                rsa = rsaRepository.getRsa(user.getEmail());
            else
                rsa = rsaRepository.addRsa(user.getEmail());

            String s = rsa.arrayToStr(rsa.encrypt(text, rsa.getPublicKey(),rsa.getN()));

             if (principal!=null)
            return new StringResponse(s);
              else
                 return new ErrorResponse("access denied ");
        }
        catch (Exception e){
            return new ErrorResponse(e.toString());
        }
    }

    @RequestMapping(value = "rsa/decrypt", method = RequestMethod.GET, produces = "application/json")
    public ResponseData getDecrypt(@RequestParam("text") String text, Principal principal){

        try{
             if (principal==null)
                return new ErrorResponse("access denied ");

             User user = repositoryUserService.getUserForEmail(principal.getName());

            if (user==null){
                return new ErrorResponse("user not found ");
            }

            Rsa rsa;
            if (rsaRepository.isHaveRsa(user.getEmail()))
                rsa = rsaRepository.getRsa(user.getEmail());
            else
                rsa = rsaRepository.addRsa(user.getEmail());

            String s = rsa.decrypt(rsa.strToArray(text),rsa.getPublicKey());

            return new StringResponse(s);

        }
        catch (Exception e){
            return new ErrorResponse(e.toString());
        }
    }


    @RequestMapping(value = "rsa/updatekey", method = RequestMethod.GET, produces = "application/json")
    public ResponseData getUpdate(Principal principal){

        try{
            if (principal==null)
                return new ErrorResponse("access denied ");

            User user = repositoryUserService.getUserForEmail(principal.getName());

            if (user==null){
                return new ErrorResponse("user not found ");
            }

            Rsa rsa;
            if (rsaRepository.isHaveRsa(user.getEmail()))
                rsa = rsaRepository.getRsa(user.getEmail());
            else
                rsa = rsaRepository.addRsa(user.getEmail());

           rsaRepository.refresh(principal.getName());

            return new StringResponse("updates keys ready");

        }
        catch (Exception e){
            return new ErrorResponse(e.toString());
        }
    }

    @RequestMapping(value = "rsa", method = RequestMethod.GET, produces = "application/json")
    public ResponseData getInfo(){

        try{

            return new StringResponse("Commands: rsa/encrypt?user=user_name&text=text, rsa/updatekey, rsa/decrypt?text=text, rsa/getkey?user=user");

        }
        catch (Exception e){
            return new ErrorResponse(e.toString());
        }
    }



}
