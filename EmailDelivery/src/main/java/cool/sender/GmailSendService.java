package cool.sender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;

public class GmailSendService implements SendService {
    private String host = "smtp.gmail.com";
    private InetAddress mailHost;
    private InetAddress localhost;
    Session session;

    BufferedReader in;
    private final static int SMTP_PORT = 587;
    PrintWriter out;
    Properties properties=null;
    public void init() {

        try {
            properties = new Properties();
            properties.load(ClassLoader.getSystemResource("gmail.properties").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        };
        final Properties finalProperties = properties;
        Properties props = new Properties();

         session = Session.getInstance(finalProperties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(finalProperties.getProperty("email"), finalProperties.getProperty("password"));
                    }
                });
    }

    public boolean send( String from, String to) throws IOException { try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(properties.getProperty("email")));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("recipient1@gmail.com"));
        message.setSubject("Testing Subject");
        message.setText("Dear Mail Crawler,"
                + "\n\n No spam to my email, please!");
        Transport.send(message);
        System.out.println("Done");
    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
    return true;
    }
}


