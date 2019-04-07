package id.co.roxas.efim.angularjsstyle.controller.component.owner;

import java.io.Serializable;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Share.Dto.UserPrivilegeCustom;
import id.co.roxas.efim.angularjsstyle.configuration.AppConfig;
import id.co.roxas.efim.angularjsstyle.controller.component.componentConfiguration;
import id.co.roxas.efim.angularjsstyle.lib.HttpInjector;
import id.co.roxas.efim.angularjsstyle.lib.RestTemplateLib;

@Service("baseController")
public abstract class BaseController extends componentConfiguration implements Serializable {

	private static final long serialVersionUID = 3669833721846080208L;

	@Autowired
	protected AppConfig appConfig;

	@Autowired
	protected RestTemplateLib restTemplateLib;

	//hanya dipakai agar dapat langsung redirect ke dashboar
	public void redirectToDashboard(HttpSession session) {
		UserPrivilegeCustom upc = new UserPrivilegeCustom();
		upc.setUserId("Roxas0309");
		upc.setProjectCode("EFIM");
		upc.setUserSessionCode("GBOLAAHQWCCDAHKLCCLV");
		upc.setUserName("Bima Satrya Sebayang");
		session.setAttribute("userPrivilageCustom", upc);
	}
	
	public String redirectToUri(HttpInjector injector, String url) {
//		if (!isAccessFromDesktop(injector.getRequest())) {
//			url = "/mobile/" + url;
//		}
		System.out.println("redirect ke url : " + url);

		String finalUrl = url;

//		if (injector.getSession() != null) {
//			UserPrivilegeCustom upc = (UserPrivilegeCustom) injector.getSession().getAttribute("userPrivilageCustom");
//			if (upc == null) {
//				finalUrl = "/head";
//			}
//
//			if (!isAccessFromDesktop(injector.getRequest())) {
//				finalUrl = "/mobile" + finalUrl;
//			}
//		}

		return finalUrl;
	}

	public boolean isAccessFromDesktop(HttpServletRequest request) {
		String userAgent = request.getHeader("user-agent");
		if (userAgent.toUpperCase().contains(" mobile ".toUpperCase())) {
			return false;
		} else {
			return true;
		}
	}

	public String sendMail(String toRecipient, String message, String subject, String messageIfSendSucces) {
		// open this to make more insecure gmail
		// https://myaccount.google.com/lesssecureapps?pli=1
		Properties props = new Properties();
		props.put("mail.smtp.host", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(appConfig.getUserGmailEfim(), appConfig.getPassGmailEfim());
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

			// ini bagian jika ingin mengirimkan sesuatu --start
			InternetHeaders headers = new InternetHeaders();
			headers.addHeader("Content-type", "text/html; charset=UTF-8");
			String html = message;
			MimeBodyPart body = new MimeBodyPart(headers, html.getBytes("UTF-8"));
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(body);
			msg.setContent(multipart);
			// ini bagian jika ingin mengirimkan sesuatu --end

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
