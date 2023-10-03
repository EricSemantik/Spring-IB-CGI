package spring.formation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import spring.formation.orchestre.Pianiste;

@Aspect
public class Regisseur {
		
	@Before("execution(* *.jouer())")
	public void eteindreLumiere(JoinPoint joinPoint) {
		if(joinPoint.getTarget() instanceof Pianiste) {
			System.out.println("Allumer le projecteur");
		}
		
		System.out.println("Le régisseur éteint les lumières");
	}
	
	@Before("@annotation(spring.formation.aspect.RideauAnnotation)")
	public void ouvrirRideau() {
		System.out.println("Ouvrir les rideaux");
	}
}
