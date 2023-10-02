package spring.formation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		context.getBeanFactory().createBean(Principal.class).run();		
		
		
		context.close();
	}

}
