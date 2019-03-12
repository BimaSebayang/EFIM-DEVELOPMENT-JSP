package id.co.roxas.efim.entity.owner.headuser;

public class TblDataUser {
	private String userId;
	private String userName;
	private String userPassword;
	private String userMail;
	private String userPhone;
	private String userSessionCode;
	private Double userMaxDbstorage;
	private String userPhoto;
	private String createdDate;
	private String userStatus;
	private String projectCode;
	private TblSessionUser tblSessionUser;
	
	public TblSessionUser getTblSessionUser() {
		return tblSessionUser;
	}
	public void setTblSessionUser(TblSessionUser tblSessionUser) {
		this.tblSessionUser = tblSessionUser;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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
	public String getUserSessionCode() {
		return userSessionCode;
	}
	public void setUserSessionCode(String userSessionCode) {
		this.userSessionCode = userSessionCode;
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
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	
}
