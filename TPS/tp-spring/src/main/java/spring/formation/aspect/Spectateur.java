package spring.formation.aspect;

public class Spectateur {
	public void assoir() {
		System.out.println("Les spectateurs s'assoient");
	}
	
	public void applaudir() {
		System.out.println("CLAP CLAP CLAP");
	}
	
	public void rembourser(Exception ex) {
		System.out.println("BOUHHHH ! Rembourser !!!");
	}
}
