package pl.rafalab.restWithSpring.Controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ErrorPageController implements ErrorController {

	public String getErrorPath() {
		return "error";
	}
	
	@GetMapping("/error")
	public String showErrorPage(){
		return "error";
	}

	
}
