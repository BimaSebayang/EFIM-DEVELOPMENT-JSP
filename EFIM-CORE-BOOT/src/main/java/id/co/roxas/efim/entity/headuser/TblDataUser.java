package id.co.roxas.efim.entity.headuser;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import id.co.roxas.efim.entity.headuser.pk.TblDataUserPk;
import id.co.roxas.efim.entity.master.TblCode;

@Entity
@Table(name = "TBL_DATA_USER", schema="HEADUSER")
@IdClass(TblDataUserPk.class)
public class TblDataUser implements Serializable{
	private static final long serialVersionUID = 1407112479642990435L;
	private String userId;
	private String userName;
	private String userPassword;
	private String userMail;
	private String userPhone;
	private Double userMaxDbstorage;
	private String userPhoto;
	private String createdDate;
	private TblCode userStatus;
	private String projectCode;
	private TblSessionUser userSessionCode;

	@ManyToOne
	@JoinColumn(name="USER_STATUS", referencedColumnName="MST_CODE_TYPE")
	public TblCode getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(TblCode userStatus) {
		this.userStatus = userStatus;
	}

	
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="USER_SESSION_CODE")
	public TblSessionUser getUserSessionCode() {
		return userSessionCode;
	}

	public void setUserSessionCode(TblSessionUser userSessionCode) {
		this.userSessionCode = userSessionCode;
	}

	@Id
	@Column(name = "USER_ID")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "USER_MAIL")
	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Column(name = "USER_PHONE")
	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "USER_PASSWORD")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "USER_MAX_DBSTORAGE")
	public Double getUserMaxDbstorage() {
		return userMaxDbstorage;
	}

	public void setUserMaxDbstorage(Double userMaxDbstorage) {
		this.userMaxDbstorage = userMaxDbstorage;
	}

	@Column(name = "USER_PHOTO")
	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	@Column(name = "CREATED_DATE")
	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "PROJECT_CODE")
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
