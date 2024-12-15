package com.example.labweek05.backend.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    private OAuth2AuthorizedClientService authorizedClientService;

    public String getOAuth2AccessToken(String clientRegistrationId) {
        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(clientRegistrationId, "user"); // "user" là ID của người dùng đã xác thực
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        return accessToken.getTokenValue();  // Trả về token
    }

    public void sendEmail(String toEmail, String subject, String body, String accessToken) throws MessagingException {
        // Tạo một MimeMessage từ JavaMailSender
        MimeMessage message = emailSender.createMimeMessage();

        // Sử dụng MimeMessageHelper để cấu hình MimeMessage
        MimeMessageHelper helper = new MimeMessageHelper(message, true);  // true cho phép gửi với kiểu multipart

        // Đặt các thông tin của email
        helper.setFrom("phanphuchau15@gmail.com");  // Địa chỉ email của bạn
        helper.setTo(toEmail);  // Địa chỉ email người nhận
        helper.setSubject(subject);  // Tiêu đề email
        helper.setText(body);  // Nội dung email

        // Thêm header "Authorization" với OAuth2 token
        message.setHeader("Authorization", "Bearer " + accessToken);

        // Gửi email
        emailSender.send(message);
    }
}
