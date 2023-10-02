package spring.formation;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Principal {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("Quel Musicien dois jouer ?");
		System.out.println("1 - Guitariste");
		System.out.println("2 - Pianiste");
		
		int choix = clavier.nextInt();
		
		String beanName = "pianiste";
		if(choix == 1) {
			beanName = "guitariste";
		}
		
		IMusicien maxime = context.getBean(beanName, IMusicien.class);
		maxime.jouer();
		
		clavier.close();
		context.close();

	}

}
