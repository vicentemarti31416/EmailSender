package com.example.demo.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmailWithAttachment() throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true); // true = multipart message
		helper.setTo("alutecval@gmail.com");
		helper.setSubject("Testing from Spring Boot");
		helper.setText("<h1>Check attachment for image!</h1>", true); // true = text/html, default = text/plain
		helper.addAttachment("spring.png", new ClassPathResource("static/images/spring.png"));	// FileSystemResource file = new FileSystemResource(new File("images/spring.png"));
		javaMailSender.send(msg);

	}

}
