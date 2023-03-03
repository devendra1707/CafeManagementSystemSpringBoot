package com.cms.utils;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.tomcat.util.http.MimeHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailUtils {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text, List<String> list) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("emailId");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);

		if (list != null && list.size() > 0)
			message.setCc(getCcArray(list));

		message.setCc(getCcArray(list));

		emailSender.send(message);
	}

	private String[] getCcArray(List<String> ccList) {
		String[] cc = new String[ccList.size()];
		for (int i = 0; i < ccList.size(); i++) {
			cc[i] = ccList.get(i);
		}
		return cc;
	}

	public void forgotMail(String to, String subject, String password) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("emailId");
		helper.setTo(to);
		helper.setSubject(subject);
		String htmlMsg = "<p><strong>Your Login details for Cafe Management System</strong><br><strong>Email:</strong>"
				+ to + "<br><strong>Password: </strong>" + password
				+ "<br><a href=\"http://localhost:4200/\">click here to login</a><p>";

		message.setContent(htmlMsg, "text/html");
		emailSender.send(message);

	}
}
