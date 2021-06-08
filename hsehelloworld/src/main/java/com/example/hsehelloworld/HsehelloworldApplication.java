package com.example.hsehelloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class HsehelloworldApplication {

	private String state = "no_state";

	@Value("${config.source:unknown}")
	private String configVariable;

	@GetMapping("/config")
	public String getConfigSource(){
		return "Configuration Source: " + configVariable;
	}

	@GetMapping
	public String helloMarcel(){
		return "Hallo Marcel schön dich zu sehen! Dein Status: " + state; 
	} 

	@GetMapping("/otherEndpoint")
	public String helloAgain(){
		return "Hello again Marcel!";
	}

	@PostMapping("/somePost/{stringParam}")
	public String withInput(@PathVariable String stringParam){
		state = stringParam;
		return "Diesen String habe ich erhalten: " + stringParam;
	}

	public static void main(String[] args) {
		SpringApplication.run(HsehelloworldApplication.class, args);
	}

}
