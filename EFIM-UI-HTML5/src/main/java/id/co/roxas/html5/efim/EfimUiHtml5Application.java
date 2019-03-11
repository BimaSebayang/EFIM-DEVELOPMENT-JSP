package id.co.roxas.html5.efim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EfimUiHtml5Application extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EfimUiHtml5Application.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EfimUiHtml5Application.class, args);
	}
	
}
