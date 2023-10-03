package spring.formation.orchestre;

import org.springframework.stereotype.Component;

import spring.formation.aspect.RideauAnnotation;

@Component
public class Ukulele implements IInstrument{

	@Override
	@RideauAnnotation
	public String toString() {
		return "ULINK ULINK ULINK";
	}
	
}
