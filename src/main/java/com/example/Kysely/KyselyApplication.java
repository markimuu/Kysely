package com.example.Kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Kysely.domain.Kysymys;
import com.example.Kysely.domain.KysymysRepository;


@SpringBootApplication
public class KyselyApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}

	@Bean
	public CommandLineRunner kysymysDemo(KysymysRepository repo) {
		return (args) -> {
			log.info("Save 5 questions");
			repo.save(new Kysymys("Sukupuoli:"));
			repo.save(new Kysymys("Status:"));
			repo.save(new Kysymys("Valitse yleisimmät ostoksesi:"));
			repo.save(new Kysymys("Mitä mieltä olet hintatasosta?"));
			repo.save(new Kysymys("Toiveita/muutoksia tuotevalikoimaan tai kahvilan toimintaan liittyen?"));
			
			
			log.info("Fetch all questions");
			for (Kysymys kysymys : repo.findAll()) {
				log.info(kysymys.toString());
			}
			
		};
		
	}
	
}
