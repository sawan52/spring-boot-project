package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String message = "Hi, testing mail sending feature in java.";
        String subject = "Java Mail Send";
        String from = "arndtvogt1@gmail.com";
        String to = "gfirebase86@gmail.com";

//        sendMail(message, subject, from, to);
        sendMailWithFile(message, subject, from, to);
    }

    private static void sendMail(String message, String subject, final String from, String to) {

        // variable for gmail host
        String host = "smtp.gmail.com";

        // get system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES: " + properties);

        // setting important info in Properties object
        // set the host
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        // Step1: get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "yauwrjjksxjhnrha");
            }
        });
        session.setDebug(true);

        // Step2: Compose your message
        MimeMessage mimeMsg = new MimeMessage(session);

        try {
            // from
            mimeMsg.setFrom(from);
            // to
            mimeMsg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // subject
            mimeMsg.setSubject(subject);
            // message
            mimeMsg.setText(message);

            // Step3: Send the mail...
            Transport.send(mimeMsg);
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendMailWithFile(String message, String subject, final String from, String to) {

        // variable for gmail host
        String host = "smtp.gmail.com";

        // get system properties
//        Properties properties = System.getProperties();
        Properties properties = new Properties();
        System.out.println("PROPERTIES: " + properties);

        // setting important info in Properties object
        // set the host
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        // Step1: get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "yauwrjjksxjhnrha");
            }
        });
//        Session session = Session.getDefaultInstance(properties, null);
        session.setDebug(true);

        // Step2: Compose your message
        MimeMessage mimeMsg = new MimeMessage(session);

        try {
            // from
            mimeMsg.setFrom(from);
            // to
            mimeMsg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // subject
            mimeMsg.setSubject(subject);

            // send file
            String path = "C:\\Users\\SawanSingh\\Downloads\\Tenant Information Form for Police Verification.pdf";
            // attach both message and file using MimeMultipart
            MimeMultipart multipart = new MimeMultipart();
            MimeBodyPart text = new MimeBodyPart();
            MimeBodyPart attachment = new MimeBodyPart();

            try {
                text.setText(message);

                File file1 = new File(path);
                attachment.attachFile(file1);

                multipart.addBodyPart(text);
                multipart.addBodyPart(attachment);
            } catch (Exception e) {
                e.printStackTrace();
            }

            mimeMsg.setContent(multipart);

            // Step3: Send the mail...
            Transport.send(mimeMsg);
            System.out.println("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
