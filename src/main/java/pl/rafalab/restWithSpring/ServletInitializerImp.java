package pl.rafalab.restWithSpring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletInitializerImp extends SpringBootServletInitializer {

	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder applicationBuilder){
		return applicationBuilder.sources(RestWithSpringApplication.class);
	}
}
