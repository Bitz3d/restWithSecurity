package pl.rafalab.restWithSpring.Controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.rafalab.restWithSpring.Model.Country;
import pl.rafalab.restWithSpring.Model.Role;
import pl.rafalab.restWithSpring.Model.User;
import pl.rafalab.restWithSpring.Services.CountryService;
import pl.rafalab.restWithSpring.Services.RoleService;
import pl.rafalab.restWithSpring.Services.UserService;
import pl.rafalab.restWithSpring.Utils.RwsUtils;
import pl.rafalab.restWithSpring.Validator.UserValidator;

@Controller
public class RegisterController {

	@Autowired
	CountryService countryService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/register")
	public String register(Model model){
		model.addAttribute("user", new User());
		return"register";
	}
	
	@ModelAttribute("countryList")
	public List<Country> getCountryList(){		
		return countryService.findAll();
	}
	
	@ModelAttribute("roleList")
	public List<Role> getRoleList(){		
		return roleService.findAll();
	}
	
	@PostMapping("/adduser")
	public String addUser(@RequestParam(value="file") MultipartFile file, 
						  User user, BindingResult bindingResult, 
						  Model model, Locale locale){
		
		String returnPare = null;	
	
		User checkIfUserExist = userService.findUserByEmail(user.getEmail());
		
		new UserValidator().validate(user, bindingResult);
		new UserValidator().validateEmailExist(checkIfUserExist, bindingResult);

		if(bindingResult.hasErrors()){
			returnPare="register";
		}else {
			userService.saveUser(user);
			if(!file.equals(null)){
				RwsUtils.saveUserFile(file, user);
			}
			model.addAttribute("message", messageSource.getMessage("user.register.succes",null ,locale));
			returnPare="index";
		}
		
		return returnPare;
	}
	
}
