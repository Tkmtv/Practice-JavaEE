package com.cit.SpringBootAPIFirst.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/test")
	@ResponseBody
	public String firstHandler() {
		return "\n\n....This is Spring Boot using STS...\n\n";
	}
	
	@RequestMapping("/home")
	public String viewHome() {
		System.out.println("I am is homepage");
		return "home.jsp";
	}
	@RequestMapping("/contact")
	public String viewContact() {
		System.out.println("I am is contact page");
		return "contact";
	}
}
