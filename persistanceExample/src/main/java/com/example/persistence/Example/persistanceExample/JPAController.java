package com.example.persistence.Example.persistanceExample;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JPAController {
    @Autowired
    private StringRepository stringRepository;
    private Logger logger = LoggerFactory.getLogger(JPAController.class);

    @GetMapping("/getListOfStrings")
	public String getStringList(){
		

        List<String> listOfStrings = new ArrayList<String>();
        stringRepository.findAll().forEach(string -> listOfStrings.add(string.getString()));;
        logger.info("strings wurde zurueckgegeben {}", listOfStrings);
		return listOfStrings.toString();
	}

	@PostMapping("/addString/{stringParam}")
	public String addString(@PathVariable String stringParam){
		//logger.debug("current list of strings {}", listOfStrings);
		stringRepository.save(new StringEntity(stringParam));
		//logger.debug("current list of strings {}", listOfStrings);
		logger.info("string wurde hinzugefuegt {}", stringParam);
		return stringParam + " wurde hinzugefuegt";
	}

	@DeleteMapping("deleteString/{stringToDelete}") 
	public String deleteString(@PathVariable String stringToDelete){
		//logger.debug("current list of strings {}", listOfStrings);
		//listOfStrings.remove(stringToDelete);
		//logger.debug("current list of strings {}", listOfStrings);
		logger.info("string wurde entfernt (falls vorhanden) {}", stringToDelete);
		return stringToDelete + " wurde (wenn vorhanden) entfernt";
	}
}
