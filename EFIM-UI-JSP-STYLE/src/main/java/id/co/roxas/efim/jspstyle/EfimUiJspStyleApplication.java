package id.co.roxas.efim.jspstyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@SpringBootApplication
public class EfimUiJspStyleApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(EfimUiJspStyleApplication.class, args);
	}

//	@Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		
//        /*registry
//                .addResourceHandler("/static/*", "/webjars/*")
//                .addResourceLocations("/static/", "/webjars/");*/
//        registry
//                .addResourceHandler("/static/**")
//                .addResourceLocations("/static/");
//        registry
//                .addResourceHandler("/webjars/**")
//                .addResourceLocations("/webjars/");
//    }
	
	
}
