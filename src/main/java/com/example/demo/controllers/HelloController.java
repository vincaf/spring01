package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {

	@GetMapping("/")
	public String sayHello(Model model) {
		model.addAttribute("messaggio", "Il messaggio è stato trasportato dal model");
		return "hello"; // nome della JSP che costituisce la view (=hello.jsp)
	}
}
