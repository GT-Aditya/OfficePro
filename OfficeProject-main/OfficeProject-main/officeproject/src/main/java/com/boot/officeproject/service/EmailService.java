package com.boot.officeproject.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;

    public void send(String email, String link) 
    {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
                helper.setFrom("adiihcr0227@gmail.com","Hitouch Technologiesa Pvt. Ltd.");
                helper.setTo(email);
                helper.setSubject("Here's is the link to reset your password");


                String content = "<p> Hello. </p>"
                                + "<p>You have requested to reset your password.</p>"
                                + "<p>Click the link below to change your password.</p>"
                                + "<p><a href=\""+link+"\">Change my password</a></p>"
                                + "<br>"
                                + "<p>Ignore this email if you do remember you password, or you have not made the request.</p>";
                helper.setText(content, true);

                mailSender.send(message);
                System.out.println("|||||||||||||Mail Sent||||||||||||");
        } catch (UnsupportedEncodingException | MessagingException e) {
            e.printStackTrace();
        }
    }
}
