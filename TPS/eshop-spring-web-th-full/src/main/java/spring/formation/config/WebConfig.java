package spring.formation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // Activation des annotations @Controller, @RequestMapping, ...
@ComponentScan("spring.formation.web") // Scanner le package où se situe les Controller
public class WebConfig implements WebMvcConfigurer {

	// Configuration des exclusions sur les urls ...../css/** vers un répertoire
	// physique
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}

	
}
