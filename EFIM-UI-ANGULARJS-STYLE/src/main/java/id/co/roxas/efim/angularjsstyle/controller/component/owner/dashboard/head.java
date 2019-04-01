package id.co.roxas.efim.angularjsstyle.controller.component.owner.dashboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import Share.Dto.UserPrivilegeCustom;
import id.co.roxas.efim.angularjsstyle.controller.component.owner.BaseController;
import id.co.roxas.efim.angularjsstyle.lib.HttpInjector;

@Controller
@RequestMapping("/dashboard")
public class head extends BaseController{
	private static final long serialVersionUID = -5072200942628657386L;

	@RequestMapping("/head")
	public String headGetter(HttpServletRequest request, HttpSession session) {
		redirectToDashboard(session);
		UserPrivilegeCustom upc = (UserPrivilegeCustom) session.getAttribute("userPrivilageCustom");
		System.out.println("session " + upc.getUserId());
		return redirectToUri(new HttpInjector(request, session), "/dashboard/head");	
	}
	
	@RequestMapping("/trial")
	public String traill(HttpServletRequest request, HttpSession session) {
		UserPrivilegeCustom upc = (UserPrivilegeCustom) session.getAttribute("userPrivilageCustom");
		System.out.println("session " + upc.getUserId());
		return redirectToUri(new HttpInjector(request, session), "/dashboard/trial");	
	}
}
