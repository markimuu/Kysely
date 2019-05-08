package com.example.Kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Kysely.domain.Kysely;
import com.example.Kysely.domain.KyselyRepository;
import com.example.Kysely.domain.Kysymys;
import com.example.Kysely.domain.KysymysRepository;
import com.example.Kysely.domain.Vastaus;
import com.example.Kysely.domain.VastausRepository;

@SpringBootApplication
public class KyselyApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}

	@Bean
	public CommandLineRunner kyselyDemo(KysymysRepository repo, VastausRepository vrepo, KyselyRepository krepo) {
		return (args) -> {
			

			
			// Kysely + otsikko ja kuvaus
			Kysely kysely1 = new Kysely("Haaga-Helian AMK:n Hav-A-Java", "Kyselyn toteuttaa ryhmä Haaga-Helian kolmannen lukuvuoden IT-tradenomiopiskelijoita. Ryhmän tarkoituksena on tutkia Pasilan Haaga-Helian Hav-A-Java -kahvilan käyttäjien kokemuksia, mielipiteitä ja mahdollisia kehitysideoita.");
						
			krepo.save(kysely1);
			
			
			log.info("Save 5 questions");
			Kysymys kysymys1 = new Kysymys("Sukupuoli:", kysely1, "Radiobutton");
			Kysymys kysymys2 = new Kysymys("Status:", kysely1, "Radiobutton");
			Kysymys kysymys3 = new Kysymys("Kerro yleisimmät ostoksesi:", kysely1, "Tekstikysymys");
			Kysymys kysymys4 = new Kysymys("Mitä mieltä olet hintatasosta?", kysely1, "Radiobutton");
			Kysymys kysymys5 = new Kysymys("Toiveita/muutoksia tuotevalikoimaan tai kahvilan toimintaan liittyen?", kysely1, "Tekstikysymys");
			repo.save(kysymys1);
			repo.save(kysymys2);
			repo.save(kysymys3);
			repo.save(kysymys4);
			repo.save(kysymys5);

				
			
			log.info("Fetch all questions");
			for (Vastaus vastaus : vrepo.findAll()) {
				log.info(vastaus.toString());
			}
			
		};
		
	}
	
}
