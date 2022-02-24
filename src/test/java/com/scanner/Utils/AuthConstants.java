package com.scanner.Utils;

import java.io.File;

import static com.scanner.MobileStaticAnalysis.buildName;
import static com.scanner.Utils.LoadProperties.authenticationProps;

public class AuthConstants {

    public static String MAF_HOST = authenticationProps.getProperty("mail.smtp.host");
    public static String MAF_PORT = authenticationProps.getProperty("mail.smtp.port");
    public static String MAF_AUTH = authenticationProps.getProperty("mail.smtp.auth");
    public static String STARTTLS_ENABLED = authenticationProps.getProperty("mail.smtp.starttls.enable");
    public static String SSL_TRUST = authenticationProps.getProperty("mail.smtp.ssl.trust");
    public static String MAF_SENDER_EMAIL = authenticationProps.getProperty("username");
    public static String MAF_SENDER_PASS = authenticationProps.getProperty("password");
    public static String FROM = authenticationProps.getProperty("From");
    public static String RECIPIENT_1 = authenticationProps.getProperty("Recipient_1");
    public static String RECIPIENT_2 = authenticationProps.getProperty("Recipient_2");
    public static String RECIPIENT_3 = authenticationProps.getProperty("Recipient_3");
    public static String BUILD_SEC_REPORT= System.getProperty("user.dir")+ File.separator + "Download.pdf";
    public static String EMAIL_BUILD_SEC_REPORT= System.getProperty("user.dir")+ File.separator + buildName +".pdf";
}
