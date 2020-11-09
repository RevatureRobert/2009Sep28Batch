package com.springy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quick")
public class QuickController {

	@GetMapping
	public String redirect() {
		return "redirect:http://www.google.com";
	}
}
