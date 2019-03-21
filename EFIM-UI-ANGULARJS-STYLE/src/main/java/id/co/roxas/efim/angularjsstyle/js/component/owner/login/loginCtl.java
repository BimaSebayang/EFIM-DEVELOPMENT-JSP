package id.co.roxas.efim.angularjsstyle.js.component.owner.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.roxas.efim.angularjsstyle.js.component.componentConfiguration;
import id.co.roxas.efim.angularjsstyle.js.component.owner.BaseController;

@Controller
@RequestMapping("/login")
public class loginCtl extends BaseController{

//	@Autowired
//	private BaseController baseController;
	
	@RequestMapping("/head")
	public String header(HttpServletRequest request) {
		if(isAccessFromDesktop(request)) {
		return "head";
		}
		else {
			return "/mobile/head";
		}
	}
	
	@RequestMapping("/enter")
	public String enter(HttpServletRequest request) {
		if(isAccessFromDesktop(request)) {
		return "login/login";
		}
		else {
		return "/mobile/login/login";
		}
	}
	
	
}
