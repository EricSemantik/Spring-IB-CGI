package spring.formation.repo.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.formation.config.ApplicationConfig;
import spring.formation.repo.IFournisseurRepository;

public class Bidon {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		IFournisseurRepository fournisseurRepo = context.getBean(IFournisseurRepository.class);
		
		context.close();
	}

}
