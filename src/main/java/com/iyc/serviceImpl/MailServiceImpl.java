package com.iyc.serviceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.iyc.service.MailService;

@Service
public class MailServiceImpl implements MailService {
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public String sendMail(HttpServletRequest req) {
		
		final String mailId = messageSource.getMessage("mail.id",
				new Object[] {}, null);
		
		final String mailPwd = messageSource.getMessage("mail.passowrd",
				new Object[] {}, null);
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailId,mailPwd);
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailId));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailId));
			message.setSubject("Blood Request--Urgent");
			message.setText("Dear Admin," +
					"\n\n "+ req.getParameter("bloodGroup")+" Blood  Required for" +
					req.getParameter("patientName")+
					"  Please Contact:"+req.getParameter("gaurdianName")+" Ph:"+
					req.getParameter("gaurdianNumber")+
					"\n\n Patient Admitted in "+req.getParameter("hospitalName")+
					"Hospital Number +"+req.getParameter("hospitalNumber")
					+"\n\n Message"+req.getParameter("message")
					);
			
			
			
			Transport.send(message);
 
			
 
		} catch (MessagingException e) {
			System.err.println(e.getMessage());
			return "failure";
		}
	
		
		
		
		
		return "success";
	}

}



