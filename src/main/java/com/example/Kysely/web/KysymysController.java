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

import com.example.Kysely.domain.Kysely;
import com.example.Kysely.domain.KyselyRepository;
import com.example.Kysely.domain.Kysymys;
import com.example.Kysely.domain.KysymysRepository;
import com.example.Kysely.domain.Vaihtoehto;
import com.example.Kysely.domain.VaihtoehtoRepository;
import com.example.Kysely.domain.Vastaus;
import com.example.Kysely.domain.VastausRepository;

@Controller
@CrossOrigin
public class KysymysController {

	@Autowired
	private KysymysRepository repo;

	@Autowired
	private VastausRepository vrepo;

	@Autowired
	private KyselyRepository krepo;
	
	@Autowired 
	private VaihtoehtoRepository vairepo;

	// REST Homepage
	@RequestMapping(value = "/resthome", method = RequestMethod.GET)
	public String resthomeList() {
		return "resthome";
	}

	// Tästä alkaa kysymys controllerit
	// REST Save new question
	@RequestMapping(value = "/kysymykset", method = RequestMethod.POST)
	public @ResponseBody Kysymys addKysymysRest(@RequestBody Kysymys kysymys) {
		return repo.save(kysymys);
	}

	// REST Get question by id
	@RequestMapping(value = "/kysymys/{kysymysid}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kysymys> findKysymysRest(@PathVariable("kysymysid") Long kysymysid) {
		return repo.findById(kysymysid);
	}

	// REST Get all questions
	@RequestMapping(value = "/kysymykset", method = RequestMethod.GET)
	public @ResponseBody List<Kysymys> kysymyksetRest() {
		return (List<Kysymys>) repo.findAll();
	}

	// Tästä alkaa vastaus controllerit
	// REST Get all answers
	@RequestMapping(value = "/vastaukset", method = RequestMethod.GET)
	public @ResponseBody List<Vastaus> vastausRest() {
		return (List<Vastaus>) vrepo.findAll();
	}

	// REST Save one answer
	@RequestMapping(value = "/vastaukset", method = RequestMethod.POST)
	public @ResponseBody Vastaus addVastausRest(@RequestBody Vastaus vastaus) {
		return vrepo.save(vastaus);
	}

	// REST Get answer by id
	@RequestMapping(value = "/vastaus/{vastausid}", method = RequestMethod.GET)
	public @ResponseBody Optional<Vastaus> findVastausRest(@PathVariable("vastausid") Long vastausid) {
		return vrepo.findById(vastausid);
	}

	// Tästä alkaa kysely controllerit
	// REST Get all polls
	@RequestMapping(value = "/kyselyt", method = RequestMethod.GET)
	public @ResponseBody List<Kysely> kyselyRest() {
		return (List<Kysely>) krepo.findAll();
	}

	// REST Save one poll
	@RequestMapping(value = "/kyselyt", method = RequestMethod.POST)
	public @ResponseBody Kysely addKyselyRest(@RequestBody Kysely kysely) {
		return krepo.save(kysely);
	}

	// REST Get poll by id
	@RequestMapping(value = "/kysely/{kyselyid}", method = RequestMethod.GET)
	public @ResponseBody Optional<Kysely> findKyselyRest(@PathVariable("kyselyid") Long kyselyid) {
		return krepo.findById(kyselyid);
	}

	// Tästä alkaa vaihtoehtojutskat
	// REST Get all question options
	@RequestMapping(value = "/vaihtoehdot", method = RequestMethod.GET)
	public @ResponseBody List<Vaihtoehto> vaihtoehtoRest() {
		return (List<Vaihtoehto>) vairepo.findAll();
	}

	// REST Save one question option
	@RequestMapping(value = "/vaihtoehdot", method = RequestMethod.POST)
	public @ResponseBody Vaihtoehto addVaihtoehtoRest(@RequestBody Vaihtoehto vaihtoehto) {
		return vairepo.save(vaihtoehto);
	}

	// REST Get question option by id
	@RequestMapping(value = "/vaihtoehto/{vaihtoehtoId}", method = RequestMethod.GET)
	public @ResponseBody Optional<Vaihtoehto> findVaihtoehtoRest(@PathVariable("vaihtoehtoId") Long vaihtoehtoId) {
		return vairepo.findById(vaihtoehtoId);
	}
	
}