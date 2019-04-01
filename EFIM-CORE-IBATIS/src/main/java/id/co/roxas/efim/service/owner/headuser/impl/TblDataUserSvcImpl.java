package id.co.roxas.efim.service.owner.headuser.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Share.Dto.HeadUser.TblDataUserDto;
import Share.Dto.HeadUser.TblSessionUserDto;
import id.co.roxas.efim.dao.owner.headuser.query.TblDataUserDao;
import id.co.roxas.efim.entity.owner.headuser.TblDataUser;
import id.co.roxas.efim.lib.Paging;
import id.co.roxas.efim.service.ConfigurationService;
import id.co.roxas.efim.service.owner.headuser.TblDataUserSvc;

@Service("tblDataUserSvc")
public class TblDataUserSvcImpl extends ConfigurationService implements TblDataUserSvc{

	@Autowired
	private TblDataUserDao tblDataUserDao;
	
	
	@Override
	public List<TblDataUserDto> selectAllUserWithParamPaging(Paging paging) {
		List<TblDataUser> tblDataUsers = tblDataUserDao.selectAllUserWithPaging(paging.getPage(),
				paging.getComposition(), paging.getOrderBy(), paging.getDirection());
		List<TblDataUserDto> dataUserDtos = new ArrayList<>();
		for (TblDataUser tblDataUser : tblDataUsers) {
			TblDataUserDto tblDataUserDto = mapperFacade.map(tblDataUser, TblDataUserDto.class);
			TblSessionUserDto tblSessionUserDto = mapperFacade.map(tblDataUser.getTblSessionUser(), TblSessionUserDto.class);
			List<TblSessionUserDto> tblSessionUserDtos = mapperFacade.mapAsList(tblDataUserDto.getTblSessionUserDtos(), TblSessionUserDto.class);
		    tblDataUserDto.setUserSessionCode(tblSessionUserDto);
		    tblDataUserDto.setTblSessionUserDtos(tblSessionUserDtos);
		    dataUserDtos.add(tblDataUserDto);
		}
		return dataUserDtos;
	}


	@Override
	public Map<String, Object> getTheResultEmailAddress(String userId, String projectCode) {
		TblDataUser tblDataUser = tblDataUserDao.getUserInformation(userId, projectCode);
		TblDataUserDto tblDataUserDto = mapperFacade.map(tblDataUser, TblDataUserDto.class);
		Map<String, Object> mapResult = new HashMap<>();
		if(tblDataUser==null) {
			tblDataUserDto = new TblDataUserDto();
			tblDataUserDto.setUserMail("ERROR");
			mapResult.put("content", tblDataUserDto);
			mapResult.put("count", 0);
		}
		else {
		mapResult.put("content", tblDataUserDto);
		mapResult.put("count", 1);
		}
		return mapResult;
	}

	
}
