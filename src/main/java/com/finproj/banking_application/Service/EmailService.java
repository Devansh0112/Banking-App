package com.finproj.banking_application.Service;


import com.finproj.banking_application.dto.EmailDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements EmailServiceInterface{

    private final JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String senderEmail;

    EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendAlertEmail(EmailDetails emailDetails) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(senderEmail);
            message.setTo(emailDetails.getRecipient());
            message.setSubject(emailDetails.getSubject());
            message.setText(emailDetails.getBody());

            mailSender.send(message);

        } catch (MailException e) {
            throw new RuntimeException(e);
        }
    }
}
