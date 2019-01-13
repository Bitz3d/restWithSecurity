package pl.rafalab.restWithSpring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.rafalab.restWithSpring.Model.Country;
import pl.rafalab.restWithSpring.Model.User;
import pl.rafalab.restWithSpring.repositories.CountryRepository;

@Controller
public class RegisterController {
	@Autowired
	private CountryRepository crepo; 
	
	@GetMapping("/register")
	public String register(Model model){
		model.addAttribute("user", new User());
		return"register";
	}
	
	@ModelAttribute("countryList")
	public List<Country> getCountryList(){		
		return crepo.findAll();
	}
	
	@PostMapping("/adduser")
	public String odp(){
		return "index";
	}
	
}
