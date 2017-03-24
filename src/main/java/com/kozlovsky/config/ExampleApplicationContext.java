package com.kozlovsky.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import java.util.Properties;

/**
 * @author anton
 */
@Configuration
@ComponentScan(basePackages = {
        "com.kozlovsky"
})
@Import({WebAppContext.class, PersistenceContext.class, SecurityContext.class, SocialContext.class})
@PropertySource("classpath:application.properties")
public class ExampleApplicationContext {

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messages";

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public VelocityEngineFactoryBean velocityEngineFactoryBean(){
        VelocityEngineFactoryBean velocityEngineFactoryBean = new VelocityEngineFactoryBean();
        velocityEngineFactoryBean.setResourceLoaderPath("WEB-INF/email-temp/");

        return velocityEngineFactoryBean;
    }

    @Bean
    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setUsername("kozlovsky.anton@gmail.com");
        javaMailSender.setPassword("50191995FYNJY");
        javaMailSender.setPort(465);

        Properties properties = new Properties();
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.starttls.required",true);
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.host","smtp.gmail.com");

        javaMailSender.setJavaMailProperties(properties);


        return javaMailSender;
    }

}
