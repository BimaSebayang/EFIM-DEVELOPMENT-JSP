package id.co.roxas.efim.service.owner.headuser.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import Share.Dto.UserPrivilegeCustom;
import Share.Dto.HeadUser.TblEfimDbDto;
import id.co.roxas.efim.dao.headuser.TblDataUserDao;
import id.co.roxas.efim.dao.headuser.TblEfimDbDao;
import id.co.roxas.efim.dao.stream.TblUserPictureProfileDao;
import id.co.roxas.efim.entity.headuser.TblDataUser;
import id.co.roxas.efim.entity.headuser.TblEfimDb;
import id.co.roxas.efim.lib.CommonConstant;
import id.co.roxas.efim.service.owner.headuser.TblEfimDbSvc;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Service("tblEfimDbSvc")
@Transactional
public class TblEfimDbSvcImpl extends CommonConstant implements TblEfimDbSvc{

	@Autowired
	private TblDataUserDao tblDataUserDao;
	
	@Autowired
	private TblUserPictureProfileDao tblUserPictureProfileDao;
	
	@Autowired
	private TblEfimDbDao tblEfimDbDao;
		
	private MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
	
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
		//userPrivilegeCustom.setUserSessionCode(tblDataUser.getUserSessionCode());
		//userPrivilegeCustom.setUserSessionCode(tblDataUser.getTblSessionUser().getUserSessionCode());
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

	@Override
	public Map<String, Object> getAllDataAndFileOwner(Map<String, Object> mapResult) {

		Map<String, Object> mapper = new HashMap<>();
		List<String> listReff = (List<String>) mapResult.get("idReffs");
		
		if(listReff==null) {
			listReff = new ArrayList<>();
			listReff.add("");
		}
		
		try {
		String fileOwner = (String) mapResult.get("userId");
		String projectCode = (String) mapResult.get("projectCode");
		List<TblEfimDb> pageTed = tblEfimDbDao.getAllDataAndFileOwner(fileOwner, projectCode, listReff);
		if(pageTed.size()!=0) {
			List<TblEfimDbDto> tblEfimDbDtos = new ArrayList<>();
			for (TblEfimDb tblEfimDb : pageTed) {
				TblEfimDbDto efimDbDto = new TblEfimDbDto();
				efimDbDto = mapperFacade.map(tblEfimDb, TblEfimDbDto.class);
				tblEfimDbDtos.add(efimDbDto);
			}
			int totalCon = (int) pageTed.size();
			int totSize = pageTed.size();
			mapper.put("content", tblEfimDbDtos);
			mapper.put("count", totalCon);
			mapper.put("error", COMMONNOERROR);
			mapper.put("size", totSize);
			
		}
		else {
			mapper.put("content", null);
			mapper.put("count", 0);
			mapper.put("error", COMMONNODATA);
		}
		}
		catch(Exception exp) {
			exp.printStackTrace();
			mapper.put("content", null);
			mapper.put("count", 0);
			mapper.put("error", exp.getMessage());
		}
		
		return mapper;
	}

}
