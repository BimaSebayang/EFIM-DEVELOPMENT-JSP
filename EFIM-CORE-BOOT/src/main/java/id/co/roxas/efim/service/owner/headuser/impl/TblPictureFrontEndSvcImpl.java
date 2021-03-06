package id.co.roxas.efim.service.owner.headuser.impl;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.roxas.efim.dao.headuser.TblPictureFrontEndDao;
import id.co.roxas.efim.entity.stream.TblPictureFrontEnd;
import id.co.roxas.efim.service.owner.headuser.TblPictureFrontEndSvc;


@Service("tblPictureFrontEndSvc")
@Transactional
public class TblPictureFrontEndSvcImpl implements TblPictureFrontEndSvc{

	@Autowired
	private TblPictureFrontEndDao tblPictureFrontEndDao;
	
	@Override
	public byte[] getTheImage(String pictureName, String projectCode) {
		TblPictureFrontEnd tblPictureFrontEnd = tblPictureFrontEndDao.getImage(pictureName, projectCode);
		return tblPictureFrontEnd.getPicturePath();
	}

}
