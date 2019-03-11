package id.co.roxas.html5.efim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
  
	@RequestMapping("/test")
	public String Test() {
	    System.out.println("Test running");
		return "test";
	}
	
}
 