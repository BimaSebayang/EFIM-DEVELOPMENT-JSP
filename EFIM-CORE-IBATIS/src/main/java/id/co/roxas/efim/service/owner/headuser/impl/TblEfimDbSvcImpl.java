package id.co.roxas.efim.service.owner.headuser.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Share.Dto.UserPrivilegeCustom;
import id.co.roxas.efim.dao.owner.headuser.query.TblDataUserDao;
import id.co.roxas.efim.dao.owner.stream.query.TblUserPictureProfileDao;
import id.co.roxas.efim.entity.owner.headuser.TblDataUser;
import id.co.roxas.efim.lib.CommonConstant;
import id.co.roxas.efim.service.ConfigurationService;
import id.co.roxas.efim.service.owner.headuser.TblEfimDbSvc;

@Service("tblEfimDbSvc")
public class TblEfimDbSvcImpl extends ConfigurationService implements TblEfimDbSvc{

	@Autowired
	private TblDataUserDao tblDataUserDao;
	
	@Autowired
	private TblUserPictureProfileDao tblUserPictureProfileDao;
	
	@Override
	public Map<String, Object> getUserInformativeMotive(Map<String, Object> mapResult) {
		String userId = (String) mapResult.get("userId");
		String projectCode = (String) mapResult.get("projectCode");
		UserPrivilegeCustom userPrivilegeCustom = new UserPrivilegeCustom();
		TblDataUser tblDataUser = tblDataUserDao.getUserInformation(userId, projectCode);
		
		Map<String, Object> mapper = new HashMap<>();
		
		if(tblDataUser!=null) {
		userPrivilegeCustom.setUserId(tblDataUser.getUserId());
		userPrivilegeCustom.setUserName(tblDataUser.getUserName());
		userPrivilegeCustom.setUserSessionCode(tblDataUser.getUserSessionCode());
		byte[] pic = tblUserPictureProfileDao.getUserPicture(tblDataUser.getUserPhoto(), projectCode);
		userPrivilegeCustom.setUserPhoto(pic);
		mapper.put("content", userPrivilegeCustom);
		mapper.put("count", 1);
		mapper.put("error", COMMONNOERROR);
		}
		else if(tblDataUser ==null) {
			mapper.put("content", userPrivilegeCustom);
			mapper.put("count", 0);
			mapper.put("error", COMMONNODATA);
		}
		return mapper;
	}

}
