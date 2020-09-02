package com.airetok.findgiph.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.airetok.findgiph.entity.User;
import com.airetok.findgiph.entity.UserGif;

@Component
public class SendBirthdayGif {
	
	@Autowired
	private GiphUserRepository giphUserRepository;
	
	@Autowired
	private GifMailService gifMailService;
    
	@Scheduled(cron = " 0 0 7 * * *")
	public void sendBirthdayGif() {
		List<UserGif> users = giphUserRepository.findAllActiveUsersNative();
		for (UserGif userGif : users) {
		User user = new User();
		user.setSubject("Best wishes to "+userGif.getFirstName()+" "+userGif.getLastName()+" from Findgiph.com");
		user.setGifUrl("https://media2.giphy.com/media/L1bPUAMXIqXpPoWk9R/giphy.gif"
				+ "?cid=858a27b89uzry3bm6xqwv485h8f5vhy765s1wd64jgusvfeg&rid=giphy.gif");
		user.setEmail(userGif.getEmail());
		gifMailService.sendGifToEmail(user);
		}
		
	}
	
}
