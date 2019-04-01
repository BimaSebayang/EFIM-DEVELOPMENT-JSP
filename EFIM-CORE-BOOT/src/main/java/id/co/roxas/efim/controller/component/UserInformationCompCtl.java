package id.co.roxas.efim.controller.component;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Share.WsResponse;
import id.co.roxas.efim.controller.ConfigurationController;
import id.co.roxas.efim.service.owner.headuser.TblEfimDbSvc;

@RestController
@RequestMapping("/UserInformationCompCtl")
public class UserInformationCompCtl extends ConfigurationController{
	
	@Autowired
	private TblEfimDbSvc tblEfimDbSvc;
	
	@RequestMapping(value = "/UserInf", method = RequestMethod.POST, params = { "projectCode" })
	public WsResponse checkAllUserInformation(@RequestBody Map<String, Object> mapperRequest, 
			@RequestParam String projectCode) {
		if (mapperRequest != null) {
			mapperRequest.put("projectCode", projectCode);
		}
		Map<String, Object> mapResult = tblEfimDbSvc.getUserInformativeMotive(mapperRequest);
		WsResponse wsResponse = new WsResponse();
		String error = (String) mapResult.get("error");
		
		try {
		if(error.equalsIgnoreCase(COMMONNOERROR)) {
		wsResponse = new WsResponse(mapResult.get("content"), (int) mapResult.get("count"), false, null,
				null);
		wsResponse.setIsErrorSvc(false);
		}
		else if(error.equalsIgnoreCase(COMMONNODATA)){
			wsResponse.setIsErrorSvc(true);
			wsResponse.setErrorCmd(NOEXIST);
		}
		else {
			wsResponse.setIsErrorSvc(true);
			wsResponse.setErrorCmd(GENERROR);
		}
		}catch(Exception exp) {
			exp.printStackTrace();
			wsResponse.setIsErrorSvc(true);
			wsResponse.setErrorCmd(exp.getMessage());
		}
		return wsResponse;
	}
}
