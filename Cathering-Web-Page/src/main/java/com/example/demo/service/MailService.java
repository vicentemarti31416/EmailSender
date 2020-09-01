package com.example.demo.service;

import java.io.IOException;

import javax.mail.MessagingException;

public interface MailService {

	void sendEmailWithAttachment() throws MessagingException, IOException;
}
