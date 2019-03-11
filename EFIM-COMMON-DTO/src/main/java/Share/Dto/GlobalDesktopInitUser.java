package Share.Dto;

import java.io.Serializable;
import java.util.List;

import Share.Dto.HeadUser.TblEfimDbDto;

public class GlobalDesktopInitUser implements Serializable{
	private static final long serialVersionUID = 3570209062478038771L;
	
	private UserPrivilegeCustom userPrivilegeCustom;
	private List<TblEfimDbDto> tblEfimDbDtos;
	
	
	public UserPrivilegeCustom getUserPrivilegeCustom() {
		return userPrivilegeCustom;
	}
	public void setUserPrivilegeCustom(UserPrivilegeCustom userPrivilegeCustom) {
		this.userPrivilegeCustom = userPrivilegeCustom;
	}
	public List<TblEfimDbDto> getTblEfimDbDtos() {
		return tblEfimDbDtos;
	}
	public void setTblEfimDbDtos(List<TblEfimDbDto> tblEfimDbDtos) {
		this.tblEfimDbDtos = tblEfimDbDtos;
	}

}
