package com.example.Kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Kysely.domain.Kysymys;
import com.example.Kysely.domain.KysymysRepository;

@Controller
@CrossOrigin
public class KysymysController {

	@Autowired
	private KysymysRepository repo;
	
	// RESTful service to get all questions
    @RequestMapping(value="/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymyksetRest() {	
        return (List<Kysymys>) repo.findAll();
    }
    
    // RESTful service to save new question 
    @RequestMapping(value="/kysymykset", method = RequestMethod.POST)
    public @ResponseBody Kysymys addKysymysRest(@RequestBody Kysymys kysymys) {	
    	return repo.save(kysymys);
    }
    
    // RESTful service to get question by id
    @RequestMapping(value="/kysymys/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("id") Long kysymysid) {	
    	return repo.findById(kysymysid);
    } 
	
}
