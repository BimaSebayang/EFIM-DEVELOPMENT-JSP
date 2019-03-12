package id.co.roxas.efim.jspstyle.lib;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.roxas.efim.jspstyle.configuration.AppConfig;

@Service
public abstract class BaseCtl {
	
	 @Autowired
	 protected RestTemplateLib restTemplateLib;
	 
	 @Autowired
	 protected AppConfig appConfig;
	 
	
	 public String sendMail(String toRecipient, String message, String subject, String messageIfSendSucces) {
		 //open this to make more insecure gmail https://myaccount.google.com/lesssecureapps?pli=1
	        Properties props = new Properties();
	        props.put("mail.smtp.host", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(appConfig.getUserGmailEfim(),appConfig.getPassGmailEfim());
	            }
	        });
	        try {
	            MimeMessage msg = new MimeMessage(session);
	            InternetAddress[] address = InternetAddress.parse(toRecipient, true);
	            msg.setRecipients(Message.RecipientType.TO, address);
	            String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
	            msg.setSubject(subject);
	            msg.setSentDate(new Date());
	            msg.setHeader("XPriority", "1");
	            
	            //ini bagian jika ingin mengirimkan sesuatu  --start
	            InternetHeaders headers = new InternetHeaders();
	            headers.addHeader("Content-type", "text/html; charset=UTF-8");
	            String html = message;
	            MimeBodyPart body = new MimeBodyPart(headers, html.getBytes("UTF-8"));
	            Multipart multipart = new MimeMultipart();
	            multipart.addBodyPart(body);
	            msg.setContent(multipart);
	          //ini bagian jika ingin mengirimkan sesuatu  --end
	            
	            
	            Transport.send(msg);
	            System.out.println("Mail has been sent successfully");
	            return messageIfSendSucces;
	        } catch (MessagingException mex) {
	            System.out.println("Unable to send an email" + mex);
	            return "Unable to send an email" + mex;
	        } catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "Unable to send an email" + e;
			}
	    }		
}
