package com.airetok.findgiph.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.airetok.findgiph.entity.AddGifInput;
import com.airetok.findgiph.entity.UserGif;

@Component
public class AccountServiceImpl implements AccountService {

	@Override
	public Map<Integer, String> getUrlsFromDb(UserGif userGif) {
		Map<Integer,String>urlsFromDb = new LinkedHashMap<Integer, String>();
		try {
		String[] urls = userGif.getUrls().split(" ",userGif.getUrls().length());
		for (int i = 1; i < urls.length; i++) {
			urlsFromDb.put(i,urls[i]);
		}
		} catch (NullPointerException e) {}
		return urlsFromDb;
	}

	@Override
	public UserGif addGifToUser(UserGif userGif, AddGifInput addGifInput) {
		 try {
			    StringBuffer stringBuffer = new StringBuffer(userGif.getUrls());
			    stringBuffer.append(" " + addGifInput.getUrl());
			    userGif.setUrls(stringBuffer.toString());
				} catch(NullPointerException e) {
					StringBuffer stringBuffer = new StringBuffer();	
					stringBuffer.append(addGifInput.getUrl());
				    userGif.setUrls(stringBuffer.toString());
				}
		return userGif;
	}

	@Override
	public UserGif deleteGifFromUser(UserGif userGif,Integer url) {
		String[]arrayUrls = userGif.getUrls().split(" ",userGif.getUrls().length());
		Map<Integer,String>urlsFromDb = new LinkedHashMap<Integer, String>();
		for (int i = 0; i < arrayUrls.length; i++) {
			urlsFromDb.put(i,arrayUrls[i]);
		}
		urlsFromDb.remove(url);
		StringBuffer stringBuffer = new StringBuffer();
		for(Map.Entry<Integer, String> pair : urlsFromDb.entrySet()) {
			stringBuffer.append(pair.getValue()+" ");
		}
		userGif.setUrls(stringBuffer.toString().trim());
		return userGif;
	}

	@Override
	public UserGif deleteAllGifsFromUser(UserGif userGif) {
		userGif.setUrls("");
		return userGif;
	}
	
	
	
	
	
	

}
