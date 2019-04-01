package id.co.roxas.efim.angularjsstyle.controller.component.owner.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.roxas.efim.angularjsstyle.controller.component.owner.BaseController;
import id.co.roxas.efim.angularjsstyle.lib.HttpInjector;

@Controller
@RequestMapping("/login")
public class loginCtl extends BaseController{

	private static final long serialVersionUID = -4231378644755333971L;

	@RequestMapping("/head")
	public String header(HttpServletRequest request) {
		return redirectToUri(new HttpInjector(request,null), "head");
	}
	
	@RequestMapping("/enter")
	public String enter(HttpServletRequest request) {
		return redirectToUri(new HttpInjector(request, null), "login/login");
	}
	
	
}
