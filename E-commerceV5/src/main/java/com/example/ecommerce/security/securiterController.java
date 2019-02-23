package com.example.ecommerce.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class securiterController {

	@RequestMapping("/login")
	public String login() 
	{
		return "login";
	}
	

	@RequestMapping("/")
	public String home() 
	{
		return "redirect:/user/index";
	}

	@RequestMapping("/403")
	public String accesdenied() 
	{
		return "403";
	}
	
	
}
