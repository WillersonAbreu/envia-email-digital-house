package br.com.enviaemail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.enviaemail.EmailInput;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void enviaEmail(EmailInput email) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("fbarreto@digitalhouse.com");
		mailMessage.setSubject(email.getAssunto());
		mailMessage.setText(email.getCorpo());
		mailMessage.setTo(email.getPara());
		mailSender.send(mailMessage);
	}
}
