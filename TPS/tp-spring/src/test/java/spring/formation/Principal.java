package spring.formation;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class Principal {
	
	@Autowired
	private IMusicien guitariste;
	@Autowired
	private IMusicien pianiste;

	public void run() {
		Scanner clavier = new Scanner(System.in);

		System.out.println("Quel Musicien dois jouer ?");
		System.out.println("1 - Guitariste");
		System.out.println("2 - Pianiste");

		int choix = clavier.nextInt();

		
		if (choix == 1) {
			guitariste.jouer();
		} else {
			pianiste.jouer();
		}

		
		clavier.close();
		
	}

}
