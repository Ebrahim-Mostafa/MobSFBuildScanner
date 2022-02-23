package com.scanner.Utils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

import static com.scanner.Utils.AuthConstants.*;
import static com.scanner.Utils.LoadProperties.authenticationProps;

public class SendMobSFReportByEmail {

    public static void sendSecurityBuildReportByEmail () {
        // Create object of Property file
//        Properties props = new Properties();
        authenticationProps.put("mail.smtp.host", MAF_HOST);
        authenticationProps.put("mail.smtp.port", MAF_PORT);
        authenticationProps.put("mail.smtp.auth", MAF_AUTH);
        authenticationProps.put("mail.smtp.starttls.enable", STARTTLS_ENABLED);
        authenticationProps.put("mail.smtp.ssl.trust", SSL_TRUST);

        // This will handle the complete authentication
        Session session = Session.getDefaultInstance(authenticationProps,

                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(MAF_SENDER_EMAIL, MAF_SENDER_PASS);

                    }

                });

        try {

            // Create object of MimeMessage class
            Message message = new MimeMessage(session);
            // Set the from address
            message.setFrom(new InternetAddress(FROM));
            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECIPIENT_1));//To
            message.setSubject("MobSF Build Security Test Report");

            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();
            String messageBody = "Kindly have a look at the latest security build test report attached.";
            String htmlText = "<font size =\"4\" face=\"arial\" >Dear all,</font>" + "<br><br>" + "<font size =\"4\" face=\"arial\" >" + messageBody + "</font>" + "</font>" + "<br><br>" + "<font size =\"4\" face=\"arial\" >Best Regards,</font>";
            messageBodyPart1.setContent(htmlText, "text/html");

            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            String fileLocation = BUILD_SEC_REPORT;

            // Create data source and pass the filename
            DataSource source = new FileDataSource(fileLocation);

            // set the handler
            messageBodyPart2.setDataHandler(new DataHandler(source));

            // set the file
            messageBodyPart2.setFileName("MobSF_Build_Report.pdf");
            messageBodyPart2.attachFile(fileLocation);

            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            // add body part 1
            multipart.addBodyPart(messageBodyPart2);

            // add body part 2
            multipart.addBodyPart(messageBodyPart1);

            // set the content
            message.setContent(multipart);

            // finally send the email
            Transport.send(message);

            System.out.println("===== Email Sent Successfully with MobSF Report!! =====");

        } catch (MessagingException | IOException e) {

            throw new RuntimeException(e);

        }
    }
}
