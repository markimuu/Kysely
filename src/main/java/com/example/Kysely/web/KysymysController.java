package com.example.Kysely.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Kysely.domain.Kysymys;
import com.example.Kysely.domain.KysymysRepository;
import com.example.Kysely.domain.Vastaus;
import com.example.Kysely.domain.VastausRepository;

@Controller
@CrossOrigin
public class KysymysController {

	@Autowired
	private KysymysRepository repo;
	
	@Autowired
	private VastausRepository vrepo;
	
	// REST Homepage
    @RequestMapping(value="/resthome", method = RequestMethod.GET)
    public String resthomeList() {	
        return "resthome";
    }
    
    // REST Save new question 
    @RequestMapping(value="/kysymykset", method = RequestMethod.POST)
    public @ResponseBody Kysymys addKysymysRest(@RequestBody Kysymys kysymys) {	
    	return repo.save(kysymys);
    }
    
    // REST Get question by id
    @RequestMapping(value="/kysymys/{kysymysid}", method = RequestMethod.GET)
    public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("kysymysid") Long kysymysid) {	
    	return repo.findById(kysymysid);
    }
    
    // REST Get all questions
    @RequestMapping(value="/kysymykset", method = RequestMethod.GET)
    public @ResponseBody List<Kysymys> kysymyksetRest() {
    	return (List<Kysymys>) repo.findAll();
    }
    
    //jotain tähän
    
    
    // REST Get all answers
    @RequestMapping(value="/vastaukset", method = RequestMethod.GET)
    public @ResponseBody List<Vastaus> vastausRest() {	
        return (List<Vastaus>) vrepo.findAll();
    }
    
    // REST Save one answer
    @RequestMapping(value="/vastaukset", method = RequestMethod.POST)
    public @ResponseBody Vastaus addVastausRest(@RequestBody Vastaus vastaus) {	
    	return vrepo.save(vastaus);
    }
    
    // REST Get answer by id
    @RequestMapping(value="/vastaus/{vastausid}", method = RequestMethod.GET)
    public @ResponseBody Optional<Vastaus> findVastausRest(@PathVariable("vastausid") Long vastausid) {	
    	return vrepo.findById(vastausid);
    }
	
}
