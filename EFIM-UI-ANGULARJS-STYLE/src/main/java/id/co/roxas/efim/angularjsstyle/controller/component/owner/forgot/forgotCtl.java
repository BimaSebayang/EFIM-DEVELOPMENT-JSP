package id.co.roxas.efim.angularjsstyle.controller.component.owner.forgot;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Share.WsResponse;
import id.co.roxas.efim.angularjsstyle.controller.component.owner.BaseController;
import id.co.roxas.efim.angularjsstyle.lib.HttpInjector;

@Controller
@RequestMapping("/forgot")
public class forgotCtl extends BaseController{

	
	@RequestMapping(value = "/head", params= {"id"})
	public String forgot(@RequestParam String id, HttpServletRequest request) {
		System.out.println("id : " + id);
		
		WsResponse wsResponse = restTemplateLib.getResultWs("/ForgotPassCtl/GetUserId", id, "post", "projectCode="+appConfig.getProjectCode());
		Map<String, Object> mapp = restTemplateLib.mapperJsonToHashMap(wsResponse.getWsContent());
		boolean boolNext = (boolean) mapp.get("result");
		if(boolNext) {
			return redirectToUri(new HttpInjector(request, null), "forgot/forgot");
		}
		else {
			return redirectToUri(new HttpInjector(request, null), "forgot/500/forgot");
		}
		
		
	}
}
