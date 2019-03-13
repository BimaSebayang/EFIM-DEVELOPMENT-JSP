package id.co.roxas.efim.controller.login;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Share.WsResponse;
import Share.Dto.HeadUser.TblDataUserDto;
import id.co.roxas.efim.controller.ConfigurationController;
import id.co.roxas.efim.dao.owner.procedure.ProcedureDao;
import id.co.roxas.efim.dao.owner.procedure.entityCustom.SpCheckValidUserEntity;
import id.co.roxas.efim.lib.AppConfig;
import id.co.roxas.efim.lib.Paging;
import id.co.roxas.efim.service.owner.headuser.TblDataUserSvc;



@RestController
@RequestMapping("/LoginCtl")
public class LoginCtl extends ConfigurationController{
	@Autowired
	private ProcedureDao procedureDao;
	
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
	
	
	@RequestMapping(value = "/ValidationUser", method = RequestMethod.POST, params = { "projectCode" })
	public WsResponse checkIfValidUser(@RequestBody Map<String, Object> inputedUser,
			@RequestHeader Map<String, Object> rh, @RequestParam String projectCode) {
		String TS = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

//		procedureDao.spCreatedHistoryAccess((String) rh.get("ip"), (String) rh.get("mac"), (String) rh.get("sn"), TS,
//				"NONE", "http://localhost:8080/EFIM-CORE/LoginCtl/ValidationUser", projectCode);
		String result = procedureDao.spCheckValidUser((String) inputedUser.get("user"),
				(String) inputedUser.get("pass"), projectCode, TS, new String());
		WsResponse wsResponse = new WsResponse(result, 1);
		return wsResponse;
	}
	
	@RequestMapping(value = "/CreateUserEmail", method = RequestMethod.POST, params = { "projectCode" })
	public WsResponse createdUserEmail(@RequestBody TblDataUserDto tblDataUserDto, @RequestHeader Map<String, Object> rh,
			@RequestParam String projectCode) {
		String TS = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
//		procedureDao.spCreatedHistoryAccess((String) rh.get("ip"), (String) rh.get("mac"), (String) rh.get("sn"), TS,
//				"NONE", "http://localhost:8080/EFIM-CORE/LoginCtl/CreateUserEmail", projectCode);
		
		//System.err.println("user " + tblDataUserDto.getUserName());
		
		String emailId = procedureDao.spCreateEmailExecute(tblDataUserDto.getUserName(), tblDataUserDto.getUserMail(),tblDataUserDto.getUserId(),
				tblDataUserDto.getMessageEmail(), tblDataUserDto.getSubjecEmail(), "", "", TS, new BigInteger("3"), projectCode);

		WsResponse wsResponse = new WsResponse(emailId, 1, false, null, null);
		return wsResponse;
	}
	
}
