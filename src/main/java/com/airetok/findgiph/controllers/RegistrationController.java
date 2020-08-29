package com.airetok.findgiph.controllers;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airetok.findgiph.entity.AddGifInput;
import com.airetok.findgiph.entity.UserGif;
import com.airetok.findgiph.services.GiphUserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	private GiphUserRepository giphUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*if database value = urls contains 'null' it throws NullPointerException (e.g. after registration new user)
	 * added try catch to solve this
	 * store urls in database in type long text with " " separator
	 * retrieve urls as string,split by " " save as array,put array values in map */
	
	@RequestMapping("/account")
	public String personalOffice(Model model,Principal principal) {
		UserGif userGif = giphUserRepository.findByUsername(principal.getName());
		model.addAttribute("userGif",userGif);
		Map<Integer,String>urlsFromDb = new LinkedHashMap<Integer, String>();
		try {
		String[] urls = userGif.getUrls().split(" ",userGif.getUrls().length());
		for (int i = 1; i < urls.length; i++) {
			urlsFromDb.put(i,urls[i]);
		}
		} catch (NullPointerException e) {}
		model.addAttribute("urlsFromDb",urlsFromDb);
		model.addAttribute("gifAdd",new AddGifInput());
		return "account";
	}
	
	@RequestMapping("/addGifToDb")
	public String addGifToDataBase(@ModelAttribute("gifAdd") AddGifInput addGifInput,Principal principal) {
		UserGif userGif = giphUserRepository.findByUsername(principal.getName());
	    try {
	    StringBuffer stringBuffer = new StringBuffer(userGif.getUrls());
	    stringBuffer.append(" " + addGifInput.getUrl());
	    userGif.setUrls(stringBuffer.toString());
		} catch(NullPointerException e) {
			StringBuffer stringBuffer = new StringBuffer();	
			stringBuffer.append(addGifInput.getUrl());
		    userGif.setUrls(stringBuffer.toString());
		}
		giphUserRepository.save(userGif);
		return "redirect:/account";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("registration",new UserGif());
		return "registration";
	}
	
	@RequestMapping("/registrationProcess")
	public String registartionProcess(@ModelAttribute ("registration") UserGif userGif) {
		userGif.setAuthority("ROLE_USER");
		userGif.setEnabled("1");
		String cryptPassword = passwordEncoder.encode(userGif.getPassword());
		userGif.setPassword(cryptPassword);
		giphUserRepository.save(userGif);
		return "redirect:/login";
		
	}
	
	@RequestMapping("/account/delete/{url}")
	public String deleteUrl(@PathVariable("url")Integer url,Principal principal) {
		UserGif userGif = giphUserRepository.findByUsername(principal.getName());
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
		giphUserRepository.save(userGif);
		return "redirect:/account";
	}
	
	@RequestMapping("/account/deleteAll")
	public String deleteAll(Principal principal) {
		UserGif userGif = giphUserRepository.findByUsername(principal.getName());
		userGif.setUrls("");
		giphUserRepository.save(userGif);
		return "redirect:/account";
	}
	
	

}
