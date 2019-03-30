package id.co.roxas.efim.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import Share.Dto.HeadUser.TblDataUserDto;
import Share.Dto.HeadUser.TblSessionUserDto;
import id.co.roxas.efim.dao.headuser.TblDataUserDao;
import id.co.roxas.efim.dao.headuser.TblSessionUserDao;
import id.co.roxas.efim.entity.headuser.TblDataUser;
import id.co.roxas.efim.entity.headuser.TblSessionUser;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@RestController
@RequestMapping("/test")
public class tester {

	private MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

	@Autowired
	TblDataUserDao tblDataUserDao;
	
	@Autowired
	TblSessionUserDao tblSessionUserDao;
	
	@RequestMapping("/all")
    public Map<String, Object> dataUsers(){
		Map<String, Object> mapper = new HashMap<>();
		List<TblDataUser> dataUser = tblDataUserDao.findAll();
		List<TblDataUserDto> dataUserDtos = new ArrayList<>();
		for (TblDataUser tblDataUser : dataUser) {
			TblDataUserDto tblDataUserDto = new TblDataUserDto();
			tblDataUserDto = mapperFacade.map(tblDataUser, TblDataUserDto.class);
			TblSessionUserDto tblSessionUserDto= mapperFacade.map(tblDataUser.getTblSessionUser(), TblSessionUserDto.class);
			tblDataUserDto.setTblSessionUserDto(tblSessionUserDto);
			dataUserDtos.add(tblDataUserDto);
		}
		mapper.put("result", new Gson().toJson(dataUserDtos));
		return mapper;
	}
	
	@RequestMapping("/all/object")
    public TblDataUserDto dataUserss(){
		TblDataUser tblDataUser = tblDataUserDao.selectByTblSessionUser();
		TblDataUserDto tblDataUserDto = mapperFacade.map(tblDataUser, TblDataUserDto.class);
		TblSessionUserDto sessionUserDto = mapperFacade.map(tblDataUser.getTblSessionUser(), TblSessionUserDto.class);
		tblDataUserDto.setTblSessionUserDto(sessionUserDto);
		return tblDataUserDto;
	}
	
	@RequestMapping("/session")
	public List<TblSessionUserDto> getSession() {
		List<TblSessionUserDto> sessionUserDto = new ArrayList<>();
		List<TblSessionUser> tblSessionUser = tblSessionUserDao.findAll();
		for (TblSessionUser ses : tblSessionUser) {
			TblSessionUserDto tblSessionUserDto = mapperFacade.map(ses, TblSessionUserDto.class);
			TblDataUserDto dataUserDto = mapperFacade.map(ses.getTblDataUser(), TblDataUserDto.class);
			tblSessionUserDto.setTblDataUserDto(dataUserDto);
			sessionUserDto.add(tblSessionUserDto);
		}
		return sessionUserDto;
	}
	
}
