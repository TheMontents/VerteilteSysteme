package com.example.ThymeleafUI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
@Controller
public class ThymeleafUiApplication {

	@Value("${welcome.recipient}")
	private String message;

	@GetMapping("/{name}")
	public String displayPage(@PathVariable String name, Model model){
		
		message = "World";
		model.addAttribute("message",message);
	
		return "page";
	}

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafUiApplication.class, args);
	}

}
