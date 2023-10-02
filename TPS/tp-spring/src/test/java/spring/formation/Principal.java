package spring.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		
		IMusicien maxime = context.getBean(IMusicien.class);
		maxime.jouer();
		
		context.close();

	}

}
