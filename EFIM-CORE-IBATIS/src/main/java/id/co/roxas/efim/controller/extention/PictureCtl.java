package id.co.roxas.efim.controller.extention;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.roxas.efim.service.owner.headuser.TblPictureFrontEndSvc;


@RestController
@RequestMapping("/PictureCtl")
public class PictureCtl {
	
	@Autowired
	TblPictureFrontEndSvc tblPictureFrontEndSvc;
	
	@RequestMapping(value = "/GetTheBackgroundPicture", method = RequestMethod.GET,params = {"projectCode","pictureName"})
	public ResponseEntity<byte[]> getImageFromDatabase(@RequestParam String pictureName, 
			@RequestParam String projectCode) {
		HttpHeaders headers = new HttpHeaders();
		System.err.println("picture id " + pictureName + " project code " + projectCode);
		byte[] media = tblPictureFrontEndSvc.getTheImage(pictureName, projectCode);
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
	    return responseEntity;
	}

}
