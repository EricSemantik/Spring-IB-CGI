import spring.formation.A;
import spring.formation.B;

public class FakeMain {

	public static void main(String[] args) {
		A a = new A();
		
		a.setRue("rue de la Paix");
		
		B b = new B();
		
		b.setMonA(a);

	}

}
