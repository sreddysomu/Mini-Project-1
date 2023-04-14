package com.ashokit.utile;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender emailSender;
	
	public boolean sendEmail(String subject,String body,String to,File f) {
		
		try {
			MimeMessage mimemessage=emailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimemessage,true);
			helper.setSubject(subject);
			helper.setText(body, true);
			helper.setTo(to);
			emailSender.send(mimemessage);
			
		}
		catch (Exception e){
			e.printStackTrace();
			
		}
		
		return false;
	}

		


}


