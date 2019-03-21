package id.co.roxas.efim.jspstyle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import id.co.roxas.efim.jspstyle.lib.BaseCtl;
import id.co.roxas.efim.jspstyle.lib.RestTemplateLib;

@Controller
public class BaseController  {
  
	@RequestMapping("/")
	public String header() {
		return "head";
	}
	
	
	
}
