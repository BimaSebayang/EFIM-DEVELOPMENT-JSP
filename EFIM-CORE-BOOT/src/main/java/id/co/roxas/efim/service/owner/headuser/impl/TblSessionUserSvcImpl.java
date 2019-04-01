package id.co.roxas.efim.service.owner.headuser.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.roxas.efim.dao.headuser.TblDataUserDao;
import id.co.roxas.efim.service.owner.headuser.TblSessionUserSvc;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;


@Service("tblSessionUserSvc")
@Transactional
public class TblSessionUserSvcImpl implements TblSessionUserSvc{

	private MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();
	
	@Autowired
	private TblDataUserDao tableDataUserDao;
	
	
}
