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
			
			Kysely kysely1 = new Kysely("Haaga-Helian AMK:n Hav-A-Java", "Kyselyn takana on ryhmä Haaga-Helian kolmannen lukukauden IT-Tradenomiopiskelijoita. Tarkoituksenamme on tutkia kahvion käyttäjien kokemuksia ja mahdollisia kehitys ideoita.");
			krepo.save(kysely1);
			
			log.info("Save 5 questions");
			Kysymys kysymys1 = new Kysymys("Sukupuoli:", kysely1, "Radiobutton");
			Kysymys kysymys2 = new Kysymys("Status:", kysely1, "Selectbox");
			Kysymys kysymys3 = new Kysymys("Valitse yleisimmät ostoksesi:", kysely1, "Tekstikysymys");
			Kysymys kysymys4 = new Kysymys("Mitä mieltä olet hintatasosta?", kysely1, "Radiobutton");
			Kysymys kysymys5 = new Kysymys("Toiveita/muutoksia tuotevalikoimaan tai kahvilan toimintaan liittyen?", kysely1, "Tekstikysymys");
			repo.save(kysymys1);
			repo.save(kysymys2);
			repo.save(kysymys3);
			repo.save(kysymys4);
			repo.save(kysymys5);
			
			Vaihtoehto vaihtoehto1_1 = new Vaihtoehto("Mies", kysymys1, 1L);
			Vaihtoehto vaihtoehto1_2 = new Vaihtoehto("Nainen", kysymys1, 2L);
			Vaihtoehto vaihtoehto1_3 = new Vaihtoehto("Muu", kysymys1, 3L);
			vairepo.save(vaihtoehto1_1);
			vairepo.save(vaihtoehto1_2);
			vairepo.save(vaihtoehto1_3);
			
			Vaihtoehto vaihtoehto2_1 = new Vaihtoehto("Opiskelija", kysymys2, 1L);
			Vaihtoehto vaihtoehto2_2 = new Vaihtoehto("Henkilökunta", kysymys2, 2L);
			Vaihtoehto vaihtoehto2_3 = new Vaihtoehto("Opettaja", kysymys2, 3L);
			Vaihtoehto vaihtoehto2_4 = new Vaihtoehto("Muu", kysymys2, 4L);
			vairepo.save(vaihtoehto2_1);
			vairepo.save(vaihtoehto2_2);
			vairepo.save(vaihtoehto2_3);
			vairepo.save(vaihtoehto2_4);
			
			Vaihtoehto vaihtoehto3_1 = new Vaihtoehto("1 = halpa", kysymys4, 1L);
			Vaihtoehto vaihtoehto3_2 = new Vaihtoehto("2", kysymys4, 2L);
			Vaihtoehto vaihtoehto3_3 = new Vaihtoehto("3", kysymys4, 3L);
			Vaihtoehto vaihtoehto3_4 = new Vaihtoehto("4", kysymys4, 4L);
			Vaihtoehto vaihtoehto3_5 = new Vaihtoehto("5 = kallis", kysymys4, 5L);
			vairepo.save(vaihtoehto3_1);
			vairepo.save(vaihtoehto3_2);
			vairepo.save(vaihtoehto3_3);
			vairepo.save(vaihtoehto3_4);
			vairepo.save(vaihtoehto3_5);

			
			log.info("Save 5 answers");
			vrepo.save(new Vastaus(null, kysymys1, vaihtoehto1_1));
			vrepo.save(new Vastaus(null, kysymys2, vaihtoehto2_1));
			vrepo.save(new Vastaus("Kahvi, tee, kaakao", kysymys3, null));
			vrepo.save(new Vastaus(null, kysymys4, vaihtoehto3_5));
			vrepo.save(new Vastaus("Hieman halvemmat hinnat ja ystävällisempi asiakaspalvelu.", kysymys5, null));
			
			
			
			log.info("Fetch all questions");
			for (Vastaus vastaus : vrepo.findAll()) {
				log.info(vastaus.toString());
			}
			
		};
		
	}
	
}
