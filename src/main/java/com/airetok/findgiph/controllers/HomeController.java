package com.airetok.findgiph.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.airetok.findgiph.entity.Giph;
import com.airetok.findgiph.entity.InputForm;
import com.airetok.findgiph.entity.User;
import com.airetok.findgiph.services.GetGiphFromApi;
import com.airetok.findgiph.services.GifMailService;

@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("getGiph")
	private GetGiphFromApi getGiphFromApi;
	
	@Autowired
	private GifMailService gifMailService;
	
	
	
	@RequestMapping(value = "/")
	public String homePage(Model model){
		model.addAttribute("input",new InputForm());
		model.addAttribute("randomInput",new InputForm());
		return "home";
		
	}
	
	@RequestMapping(value = "/searchGif")
	public String search(@ModelAttribute ("input") InputForm input,Model model) {
		String url = "https://api.giphy.com/v1/gifs/search?api_key=TEHcJcE3JMXy2g3gnDfQB0SviJFv5IV2"
				+ "&q="+input.getInputForm()+"&limit=25&offset=0&rating=r&lang=en\r\n";
		List<Giph>listOfGiphs = getGiphFromApi.getGiphs(url);
		model.addAttribute("giphs", listOfGiphs);
		return "result";
	}
	
	@RequestMapping(value = "/mostPopular")
	public String trending(Model model) {
		String url = "https://api.giphy.com/v1/gifs/trending?api_key=TEHcJcE3JMXy2g3gnDfQB0SviJFv5IV2";
		List<Giph>listOfGiphs = getGiphFromApi.getGiphs(url);
		model.addAttribute("giphs", listOfGiphs);
		return "popular";
	}
	
	@RequestMapping(value = "/singleResult")
	public String singleResult(@ModelAttribute ("randomInput") InputForm inputForm,Model model) {
		String url = "https://api.giphy.com/v1/gifs/random?api_key=TEHcJcE3JMXy2g3gnDfQB0SviJFv5IV2&tag="+inputForm.getInputForm()+"&rating=g";
		try {
		model.addAttribute("gif",getGiphFromApi.getRandomGiph(url));
		} catch(Exception e) {
			model.addAttribute("gif",new Giph("", "", null, ""));
			e.getMessage();
		}
		return "random";
	}
	
	@RequestMapping(value = "/random")
	public String singleResult(Model model) {
		String url = "https://api.giphy.com/v1/gifs/random?api_key=TEHcJcE3JMXy2g3gnDfQB0SviJFv5IV2&tag=&rating=g";
		model.addAttribute("gif",getGiphFromApi.getRandomGiph(url));
		return "random";
	}
	
	@RequestMapping("/submitGifToEmail")
	public String submitGifToEmail(Model model) {
		model.addAttribute("user",new User());
		return "sendMailPage";
	}
	
	@RequestMapping("/sendGif")
	public String sendGif(@ModelAttribute ("user") User user) {
		try {
			gifMailService.sendGifToEmail(user);
		} catch (MailException e) {
			e.printStackTrace();
		}
		return "redirect:/submitGifToEmail";
	}
	
	
	

}
