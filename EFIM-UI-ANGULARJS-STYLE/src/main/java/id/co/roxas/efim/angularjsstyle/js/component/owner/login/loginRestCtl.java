package id.co.roxas.efim.angularjsstyle.js.component.owner.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Share.WsResponse;
import Share.Dto.UserPrivilegeCustom;
import id.co.roxas.efim.angularjsstyle.js.component.owner.BaseController;

@RestController
@RequestMapping("/rest/login")
public class loginRestCtl extends BaseController{
     
	@RequestMapping(value = "/validation", method = RequestMethod.POST)
	public String isValidToContinue(@RequestBody Map<String, Object> body, HttpServletRequest request) {
		System.out.println("masuk ke bagian validation");
		System.out.println(body.get("user"));
		System.out.println(body.get("pass"));
		if(isAccessFromDesktop(request)) {
			return "/login/enter";
		}
		else {
			return "/mobile/login/login.html";
		}
//		body.put("user", body.get("user"));
//		body.put("pass", body.get("pass"));
//		WsResponse response = restTemplateLib.getResultWs("/LoginCtl/ValidationUser", body, "post",
//				"projectCode=" + appConfig.getProjectCode());
//		Map<String, Object> resultMap = new HashMap<>();
//		resultMap = restTemplateLib.mapperJsonToHashMap(response.getWsContent());
//		boolean pass = (boolean) resultMap.get("pass");
//		System.out.println("pass : " + pass);
//		if(pass) {
//			Map<String, Object> mapBody = new HashMap<>();
//			mapBody.put("userId", body.get("user"));
//			WsResponse resp01 = restTemplateLib.getResultWs("/UserInformationCompCtl/UserInf", mapBody, "post",
//					"projectCode=" + appConfig.getProjectCode());
//			UserPrivilegeCustom upc = null;
//			try {
//				upc = restTemplateLib.mapperJsonToSingleDto(resp01.getWsContent(), UserPrivilegeCustom.class);
//				System.err.println("apakah upc ada " + upc.getUserName());
//				
//				//mv.setViewName("login/login");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			
//			if(upc!=null) {
//				
//				//mv.setViewName("login/login");
//			}	
//		 }
	}
	
}
