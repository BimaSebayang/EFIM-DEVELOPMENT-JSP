package id.co.roxas.efim.jspstyle.controller.forgot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import id.co.roxas.efim.jspstyle.configuration.AppConfig;
import id.co.roxas.efim.jspstyle.lib.BaseCtl;

@Controller
public class ForgotCtl extends BaseCtl{

	@Autowired
	private AppConfig appConfig;
	
    private Map<String, Object> modelMap = new HashMap<>();
    

	@RequestMapping("/forgot")
	public ModelAndView forgot() {
		ModelAndView mv = new ModelAndView("forgot/forgotPr");
		return mv;
	}
}
