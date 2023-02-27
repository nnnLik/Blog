package com.javablog.Blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class AboutController {

	@GetMapping("/about")
	public String about(Model model) {
		return "about";
	}
}