package com.ngo.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailService {

    private String smtpAuth;
    private String starttls;
    private String host;
    private String port;
    private String username;
    private String password;

    public MailService() {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("src/main/java/resources/mail.properties");
            props.load(fis);

            smtpAuth = props.getProperty("mail.smtp.auth");
            starttls = props.getProperty("mail.smtp.starttls.enable");
            host = props.getProperty("mail.smtp.host");
            port = props.getProperty("mail.smtp.port");
            username = props.getProperty("mail.username");
            password = props.getProperty("mail.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendThankYouEmail(String toEmail, String name, String donationType, String amount) {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", smtpAuth);
        prop.put("mail.smtp.starttls.enable", starttls);
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);

        Session session = Session.getInstance(prop, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // sender
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)); // receiver
            message.setSubject("Thank You for Your Donation!");
            String msg = "Dear " + name + ",\n\nThank you for your generous donation of "
                    + amount + " (" + donationType + "). We appreciate your support!\n\nSincerely,\nNGO Team";
            message.setText(msg);
            Transport.send(message);

            System.out.println("✅ Thank You email sent successfully to " + toEmail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
