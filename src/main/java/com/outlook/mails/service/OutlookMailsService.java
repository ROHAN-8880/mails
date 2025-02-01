//package com.outlook.mails.service;
//
//
//import com.outlook.mails.model.OutlookMails;
//import com.outlook.mails.repository.OutlookMailsRepository;
//import jakarta.mail.*;
//import jakarta.mail.internet.InternetAddress;
//import jakarta.mail.internet.MimeMessage;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Properties;
//
//@Service
//public class OutlookMailsService {
//
//    private final OutlookMailsRepository outlookMailsRepository;
//
//    public OutlookMailsService(OutlookMailsRepository outlookMailsRepository) {
//          this.outlookMailsRepository = outlookMailsRepository;
//    }
//
//    @Value("${mail.store.protocol}")
//    private String protocol;
//
//    @Value("${mail.imap.host}")
//    private String host;
//
//    @Value("${mail.imap.port}")
//    private String port;
//
//    @Value("${spring.datasource.username}")
//    private String email;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    public void fetchEmails() {
//        try {
//            // Configure mail session
//            Properties properties = new Properties();
//            properties.put("mail.store.protocol", protocol);
//            properties.put("mail.imap.host", host);
//            properties.put("mail.imap.port", port);
//            properties.put("mail.imap.ssl.enable", "true");
//
//            Session session = Session.getInstance(properties);
//            Store store = session.getStore(protocol);
//            store.connect(host, email, password);
//
//            // Access the inbox
//            Folder inbox = store.getFolder("INBOX");
//            inbox.open(Folder.READ_ONLY);
//
//            // Fetch messages
//            Message[] messages = inbox.getMessages();
//            for (Message message : messages) {
//                if (message instanceof MimeMessage) {
//                    MimeMessage mimeMessage = (MimeMessage) message;
//
//                    String sender = ((InternetAddress) mimeMessage.getFrom()[0]).getAddress();
//                    String subject = mimeMessage.getSubject();
//                    String body = message.getContent().toString();
//                    LocalDateTime receivedAt = mimeMessage.getReceivedDate().toInstant()
//                            .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime();
//
//                    // Check for keywords in the body
//                    if (body.contains("File name") && body.contains("count") && body.contains("mode")) {
//                        // Save email to database
//                        OutlookMails outlookMailsEntity = new OutlookMails();
//                        outlookMailsEntity.setSender(sender);
//                        outlookMailsEntity.setSubject(subject);
//                        outlookMailsEntity.setBody(body);
//                        outlookMailsEntity.setReceivedAt(receivedAt);
//
//                        OutlookMailsRepository.Save(outlookMailsEntity);
//                    }
//                }
//            }
//
//            inbox.close(false);
//            store.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
