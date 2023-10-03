package spring.formation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

//@Component
@Aspect
public class Fake {

	@Around("execution(* *.*(..))")
	public void rigolo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// autour avant
		
		proceedingJoinPoint.proceed();
		
		// autour après
		
	}
}
