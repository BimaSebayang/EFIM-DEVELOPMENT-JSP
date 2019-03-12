package id.co.roxas.efim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.roxas.efim.dao.TblDataUserDao;
import id.co.roxas.efim.entity.owner.headuser.TblDataUser;

@RestController
@RequestMapping("/TblDataUserCtl")
public class TblDataUserCtl {
    
	@Autowired
	private TblDataUserDao tblDataUserDao;

	@PostMapping("/all/param/{page}/{direction}")
	public List<TblDataUser> getAllParam(@PathVariable("page") int page, 
			@PathVariable("direction") String direction, 
			@RequestBody String orderBy){
		List<TblDataUser> dataUser = tblDataUserDao.findAllWithOrderByParam(orderBy,direction,page);
		return dataUser;
	}
	
	@RequestMapping("/all/noparam/{page}")
	public List<TblDataUser> getAllNoParam(@PathVariable("page") int page){
		List<TblDataUser> dataUser = tblDataUserDao.findAll(page);
		return dataUser;
	}
	
	
	@RequestMapping("/count")
	public Integer count() {
		return tblDataUserDao.countUser();
	}
	
	@RequestMapping("/allUser")
	public List<String> getAllUser(){
		return tblDataUserDao.getAllUser();
	}
}
