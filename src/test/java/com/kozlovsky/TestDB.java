package com.kozlovsky;

import com.kozlovsky.config.ExampleApplicationConfig;
import com.kozlovsky.config.ExampleApplicationContext;
import com.kozlovsky.user.model.SigninEnity;
import com.kozlovsky.user.model.User;
import com.kozlovsky.user.repository.SinginRepository;
import com.kozlovsky.user.repository.UserRepository;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anton on 24.03.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExampleApplicationContext.class})
public class TestDB {

    @Autowired
    private UserRepository userRepository;

    private SinginRepository singinRepository;

    @Test
    public void test(){
        User user = userRepository.findOne(4L);

        System.out.println(user);

       /* List<SigninEnity> signinEnityList =  new ArrayList<>();
        SigninEnity signinEnity = new SigninEnity(DateTime.now(),"lololol");

        signinEnityList.add(signinEnity);

        singinRepository.save( new SigninEnity(DateTime.now(),"lololol"));

        user.setAcc(signinEnityList);

        repositoryMock.save(user);*/
    }
}
