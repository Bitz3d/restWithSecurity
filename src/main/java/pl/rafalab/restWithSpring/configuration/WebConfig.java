package pl.rafalab.restWithSpring.configuration;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	 @Bean
	    public MultipartConfigElement multipartConfigElement(){
	    	MultipartConfigFactory configFactory = new MultipartConfigFactory();
	    	configFactory.setMaxFileSize(DataSize.ofKilobytes(500));
	    	return configFactory.createMultipartConfig();
	    }
}
