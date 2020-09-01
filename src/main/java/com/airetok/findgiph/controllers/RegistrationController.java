package com.airetok.findgiph.controllers;
import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.airetok.findgiph.entity.AddGifInput;
import com.airetok.findgiph.entity.UserGif;
import com.airetok.findgiph.services.AccountService;
import com.airetok.findgiph.services.GiphUserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	private GiphUserRepository giphUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AccountService accountService;
	
	/*if database value = urls contains 'null' it throws NullPointerException (e.g. after registration new user)
	 * added try catch to solve this
	 * store urls in database in type long text with " " separator
	 * retrieve urls as string,split by " " save as array,put array values in map */
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	
	@RequestMapping("/account")
	public String personalOffice(Model model,Principal principal) {
		UserGif userGif = giphUserRepository.findByUsername(principal.getName());
		model.addAttribute("userGif",userGif);
		model.addAttribute("urlsFromDb",accountService.getUrlsFromDb(userGif));
		model.addAttribute("gifAdd",new AddGifInput());
		return "account";
	}
	
	@RequestMapping("/addGifToDb")
	public String addGifToDataBase(@ModelAttribute("gifAdd") AddGifInput addGifInput,Principal principal) {
		UserGif userGif = giphUserRepository.findByUsername(principal.getName());
		giphUserRepository.save(accountService.addGifToUser(userGif, addGifInput));
		return "redirect:/account";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("registration",new UserGif());
		return "registration";
	}
	
	@RequestMapping("/registrationProcess")
	public String registartionProcess(@Valid@ModelAttribute ("registration") UserGif userGif,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/registration";
		}
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
		giphUserRepository.save(accountService.deleteGifFromUser(userGif, url));
		return "redirect:/account";
	}
	
	@RequestMapping("/account/deleteAll")
	public String deleteAll(Principal principal) {
		UserGif userGif = giphUserRepository.findByUsername(principal.getName());
		giphUserRepository.save(accountService.deleteAllGifsFromUser(userGif));
		return "redirect:/account";
	}
	
	

}
