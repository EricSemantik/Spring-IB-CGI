package spring.formation.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.formation.orchestre.Guitare;
import spring.formation.orchestre.Guitariste;
import spring.formation.orchestre.IInstrument;
import spring.formation.orchestre.Pianiste;
import spring.formation.orchestre.Piano;
import spring.formation.orchestre.Synthe;
import spring.formation.orchestre.Ukulele;

@Configuration
//@ComponentScan("spring.formation")
public class ApplicationConfig {

	@Bean
	public Piano piano() {
		return new Piano();
	}
	
	@Bean
	public Synthe synthe() {
		return new Synthe();
	}
	
	@Bean
	public Guitare guitare() {
		return new Guitare();
	}
	
	@Bean
	public Ukulele ukulele() {
		return new Ukulele();
	}

	@Bean
	public Guitariste guitariste(IInstrument ukulele) {
		return new Guitariste(ukulele, "Vive le vent ...");
	}

	@Bean
	public Pianiste pianiste(@Qualifier("synthe") IInstrument instrument) {
		Pianiste pianiste = new Pianiste();
		pianiste.setInstrument(instrument);
		pianiste.setMorceau("Frère Jacques");

		return pianiste;
	}

}
