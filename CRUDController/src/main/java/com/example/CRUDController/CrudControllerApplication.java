package com.example.CRUDController;

import java.util.ArrayList;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
//gleichbedeutend mit @SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class CrudControllerApplication {

	ArrayList<String> listOfStrings = new ArrayList<String>();
	private Logger logger = LoggerFactory.getLogger(CrudControllerApplication.class);

	@GetMapping("/getListOfStrings")
	public String getStringList(){
		logger.info("strings wurde zurueckgegeben {}", listOfStrings);
		return listOfStrings.toString();
	}

	@PostMapping("/addString/{stringParam}")
	public String addString(@PathVariable String stringParam){
		logger.debug("current list of strings {}", listOfStrings);
		listOfStrings.add(stringParam);
		logger.debug("current list of strings {}", listOfStrings);
		logger.info("string wurde hinzugefuegt {}", stringParam);
		return stringParam + " wurde hinzugefuegt";
	}

	@DeleteMapping("deleteString/{stringToDelete}") 
	public String deleteString(@PathVariable String stringToDelete){
		logger.debug("current list of strings {}", listOfStrings);
		listOfStrings.remove(stringToDelete);
		logger.debug("current list of strings {}", listOfStrings);
		logger.info("string wurde entfernt (falls vorhanden) {}", stringToDelete);
		return stringToDelete + " wurde (wenn vorhanden) entfernt";
	}

	@PutMapping("updateString/{oldString}/{newString}")
	public String updateString(@PathVariable String newString, @PathVariable String oldString){
		logger.debug("current list of strings {}", listOfStrings);
		Collections.replaceAll(listOfStrings, oldString, newString);
		logger.debug("current list of strings {}", listOfStrings);
		logger.error("string {} wurde durch {} ersetzt", oldString, newString);
		return "updated list: " + listOfStrings.toString();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CrudControllerApplication.class, args);
	}
}

 