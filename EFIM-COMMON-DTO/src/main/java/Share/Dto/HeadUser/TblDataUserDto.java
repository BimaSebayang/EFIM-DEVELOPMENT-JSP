package Share.Dto.HeadUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Share.Dto.Master.TblCodeDto;


public class TblDataUserDto implements Serializable{
	private static final long serialVersionUID = 4180449126938812144L;
    private String userId;
    private String userName;
    private String userPassword;
    private Double userMaxDbstorage;
    private String userMail;
	private String userPhone;
    private String userPhoto;
    private String createdDate;
    private TblCodeDto userStatus;
	private TblSessionUserDto userSessionCode;
    private String projectCode;
    private List<TblSessionUserDto> tblSessionUserDtos = new ArrayList<TblSessionUserDto>();
    private String messageEmail;
    private String subjecEmail;
    
    
    
 
	public TblCodeDto getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(TblCodeDto userStatus) {
		this.userStatus = userStatus;
	}
	public List<TblSessionUserDto> getTblSessionUserDtos() {
		return tblSessionUserDtos;
	}
	public void setTblSessionUserDtos(List<TblSessionUserDto> tblSessionUserDtos) {
		this.tblSessionUserDtos = tblSessionUserDtos;
	}
	public String getMessageEmail() {
		return messageEmail;
	}
	public void setMessageEmail(String messageEmail) {
		this.messageEmail = messageEmail;
	}
	public String getSubjecEmail() {
		return subjecEmail;
	}
	public void setSubjecEmail(String subjecEmail) {
		this.subjecEmail = subjecEmail;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Double getUserMaxDbstorage() {
		return userMaxDbstorage;
	}
	public void setUserMaxDbstorage(Double userMaxDbstorage) {
		this.userMaxDbstorage = userMaxDbstorage;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	
	
	public TblSessionUserDto getUserSessionCode() {
		return userSessionCode;
	}
	public void setUserSessionCode(TblSessionUserDto userSessionCode) {
		this.userSessionCode = userSessionCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
    
    
}
