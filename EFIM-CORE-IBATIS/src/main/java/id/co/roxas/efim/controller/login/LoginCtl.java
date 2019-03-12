package id.co.roxas.efim.controller.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Share.Dto.HeadUser.TblDataUserDto;
import id.co.roxas.efim.controller.ConfigurationController;
import id.co.roxas.efim.lib.AppConfig;
import id.co.roxas.efim.lib.Paging;
import id.co.roxas.efim.service.owner.headuser.TblDataUserSvc;

@RestController
@RequestMapping("/loginCtl")
public class LoginCtl extends ConfigurationController{

	@Autowired
	private AppConfig appconfig;
	
	@Autowired
	private TblDataUserSvc tblDataUserSvc;
	
	@GetMapping(value="tester",params= {"page","orderBy","direction"})
	public List<TblDataUserDto> testing(@RequestParam int page, 
			@RequestParam String orderBy, @RequestParam String direction){
		Paging paging = new Paging(page, appconfig.getPagingNumber(), orderBy, direction);
		return tblDataUserSvc.selectAllUserWithParamPaging(paging);
	}
	
}
