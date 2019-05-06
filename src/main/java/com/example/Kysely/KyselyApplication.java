package com.example.Kysely;

import java.util.ArrayList;
import java.util.List;

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
import com.example.Kysely.domain.Vaihtoehto;
import com.example.Kysely.domain.VaihtoehtoRepository;
import com.example.Kysely.domain.Vastaus;
import com.example.Kysely.domain.VastausRepository;

@SpringBootApplication
public class KyselyApplication {

	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}

	@Bean
	public CommandLineRunner kyselyDemo(KysymysRepository repo, VastausRepository vrepo, KyselyRepository krepo, VaihtoehtoRepository vairepo) {
		return (args) -> {
			
			// Kysely + otsikko ja kuvaus
			Kysely kysely1 = new Kysely("Haaga-Helian AMK:n Hav-A-Java", "Kyselyn toteuttaa ryhmä Haaga-Helian kolmannen lukuvuoden IT-tradenomiopiskelijoita. Ryhmän tarkoituksena on tutkia Pasilan Haaga-Helian Hav-A-Java -kahvilan käyttäjien kokemuksia, mielipiteitä ja mahdollisia kehitysideoita.");
			Kysely kysely2 = new Kysely("Haaga-Helian AMK:n Hav-A-Java", "Kyselyn toteuttaa ryhmä Haaga-Helian kolmannen lukuvuoden IT-tradenomiopiskelijoita. Ryhmän tarkoituksena on tutkia Pasilan Haaga-Helian Hav-A-Java -kahvilan käyttäjien kokemuksia, mielipiteitä ja mahdollisia kehitysideoita.");
			
			krepo.save(kysely1);
			krepo.save(kysely2);
			
			log.info("Save 5 questions");
			Kysymys kysymys1 = new Kysymys("Sukupuoli:", kysely1);
			Kysymys kysymys2 = new Kysymys("Status:", kysely1);
			Kysymys kysymys3 = new Kysymys("Kerro yleisimmät ostoksesi:", kysely1);
			Kysymys kysymys4 = new Kysymys("Mitä mieltä olet hintatasosta?", kysely1);
			Kysymys kysymys5 = new Kysymys("Toiveita/muutoksia tuotevalikoimaan tai kahvilan toimintaan liittyen?", kysely1);
			repo.save(kysymys1);
			repo.save(kysymys2);
			repo.save(kysymys3);
			repo.save(kysymys4);
			repo.save(kysymys5);
			
			//Kysymys 1 vaihtoehdot
			Vaihtoehto vaihtoehto1_1 = new Vaihtoehto("Mies", 1L, kysymys1);
			Vaihtoehto vaihtoehto1_2 = new Vaihtoehto("Nainen", 2L, kysymys1);
			Vaihtoehto vaihtoehto1_3 = new Vaihtoehto("Muu", 3L, kysymys1);
			vairepo.save(vaihtoehto1_1);
			vairepo.save(vaihtoehto1_2);
			vairepo.save(vaihtoehto1_3);
			
			//Kysymys 2 vaihtoehdot
			Vaihtoehto vaihtoehto2_1 = new Vaihtoehto("Opiskelija", 1L, kysymys2);
			Vaihtoehto vaihtoehto2_2 = new Vaihtoehto("Henkilökunta", 2L, kysymys2);
			Vaihtoehto vaihtoehto2_3 = new Vaihtoehto("Opettaja", 3L, kysymys2);
			Vaihtoehto vaihtoehto2_4 = new Vaihtoehto("Muu", 4L, kysymys2);
			vairepo.save(vaihtoehto2_1);
			vairepo.save(vaihtoehto2_2);
			vairepo.save(vaihtoehto2_3);
			vairepo.save(vaihtoehto2_4);
			
			//Kysymys 3 vaihtoehdot
			Vaihtoehto vaihtoehto3_1 = new Vaihtoehto("Text", 1L, kysymys3);
			vairepo.save(vaihtoehto3_1);
			
			//Kysymys 4 vaihtoehdot KORJAA DEFINE
			Vaihtoehto vaihtoehto4_1 = new Vaihtoehto("Radio 1", 1L, kysymys4);
			Vaihtoehto vaihtoehto4_2 = new Vaihtoehto("Radio 2", 2L, kysymys4);
			Vaihtoehto vaihtoehto4_3 = new Vaihtoehto("Radio 3", 3L, kysymys4);
			Vaihtoehto vaihtoehto4_4 = new Vaihtoehto("Radio 4", 4L, kysymys4);
			Vaihtoehto vaihtoehto4_5 = new Vaihtoehto("Radio 5", 5L, kysymys4);
			vairepo.save(vaihtoehto4_1);
			vairepo.save(vaihtoehto4_2);
			vairepo.save(vaihtoehto4_3);
			vairepo.save(vaihtoehto4_4);
			vairepo.save(vaihtoehto4_5);
			
			//Kysymys 5 vaihtoehdot
			Vaihtoehto vaihtoehto5_1 = new Vaihtoehto("Text", 1L, kysymys5);
			vairepo.save(vaihtoehto5_1);
			
			log.info("Save Mark's 5 answers");
			vrepo.save(new Vastaus("Mies", kysymys1, vaihtoehto1_1));
			vrepo.save(new Vastaus("Opiskelija", kysymys2, vaihtoehto2_1));
			vrepo.save(new Vastaus("Tee, Leipä, Puuro", kysymys3, vaihtoehto3_1));
			vrepo.save(new Vastaus("4", kysymys4, vaihtoehto4_1));
			vrepo.save(new Vastaus("Hieman halvemmat hinnat ja ystävällisempi asiakaspalvelu.", kysymys5, vaihtoehto5_1));
			
			log.info("Save Ronis's 5 answers");
			vrepo.save(new Vastaus("Mies", kysymys1, vaihtoehto1_1));
			vrepo.save(new Vastaus("Muu", kysymys2, vaihtoehto2_1));
			vrepo.save(new Vastaus("Novelle vesi", kysymys3, vaihtoehto3_1));
			vrepo.save(new Vastaus("1", kysymys4, vaihtoehto4_1));
			vrepo.save(new Vastaus("Ihan jees.", kysymys5, vaihtoehto5_1));
			
			log.info("Fetch all questions");
			for (Vastaus vastaus : vrepo.findAll()) {
				log.info(vastaus.toString());
			}
			
		};
		
	}
	
}
