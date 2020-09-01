package com.example.demo;

import java.io.IOException;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.MailService;

@SpringBootApplication
public class CatheringWebPageApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CatheringWebPageApplication.class, args);
	}

	@Autowired
	private MailService mailService;

	@Override
	public void run(String... args) {
		System.out.println("Sending Email...");
		try {
			mailService.sendEmailWithAttachment();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
