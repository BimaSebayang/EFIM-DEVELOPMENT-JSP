package id.co.roxas.efim.service.owner.headuser.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.roxas.efim.dao.owner.headuser.query.TblPictureFrontEndDao;
import id.co.roxas.efim.entity.owner.stream.TblPictureFrontEnd;
import id.co.roxas.efim.service.ConfigurationService;
import id.co.roxas.efim.service.owner.headuser.TblPictureFrontEndSvc;


@Service("tblPictureFrontEndSvc")
public class TblPictureFrontEndSvcImpl extends ConfigurationService implements TblPictureFrontEndSvc{


	@Autowired
	private TblPictureFrontEndDao tblPictureFrontEndDao;
	
	@Override
	public byte[] getTheImage(String pictureName, String projectCode) {
		TblPictureFrontEnd tblPictureFrontEnd = tblPictureFrontEndDao.getImage(pictureName, projectCode);
		return tblPictureFrontEnd.getPicturePath();
	}

}
