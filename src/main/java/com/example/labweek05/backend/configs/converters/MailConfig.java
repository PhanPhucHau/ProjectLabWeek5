package com.example.labweek05.backend.configs.converters;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {
    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.properties.mail.smtp.oauth2.client-id}")
    private String clientId;


    @Value("${spring.mail.properties.mail.smtp.oauth2.scope}")
    private String scope;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername(username);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Cấu hình OAuth2 (token sẽ được tự động cung cấp)
        props.put("mail.smtp.user", username);
        props.put("mail.smtp.oauth2.client-id", clientId);
        props.put("mail.smtp.oauth2.scope", scope);

        return mailSender;
    }
}
