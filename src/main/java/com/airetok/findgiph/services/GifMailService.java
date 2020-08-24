package com.airetok.findgiph.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.airetok.findgiph.entity.User;

@Service
public class GifMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public GifMailService(JavaMailSender javaMailSender) throws MailException {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendGifToEmail(User user) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setSubject(user.getSubject());
		mail.setText(user.getGifUrl());
		javaMailSender.send(mail);
	}
	
	
	
}
