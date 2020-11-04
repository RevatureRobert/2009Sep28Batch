package com.webby.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	@GetMapping("/home.app")
	public String home() {
		return "html/home.html";
	}
}
