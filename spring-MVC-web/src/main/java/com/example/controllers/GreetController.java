package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {

	@RequestMapping("/greetMessage")
	public String greetMessage(Model model) {
		model.addAttribute("message", "have a great day");
		return "success";
	}
	@RequestMapping(value = "/sayHello",method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("message", "Hello MVC");
		return "success";
	}
	@GetMapping("/welcome")
	public ModelAndView greetMessage() {
		ModelAndView model = new ModelAndView("success","message", "Welcome to MVC");
		return model;
	}
}
