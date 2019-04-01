package id.co.roxas.efim.entity.headuser;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import id.co.roxas.efim.entity.headuser.pk.TblSessionUserPk;


@Entity
@Table(name="TBL_SESSION_USER", schema="HEADUSER")
@IdClass(TblSessionUserPk.class)
//@Access(AccessType.FIELD)
public class TblSessionUser implements Serializable{
	private static final long serialVersionUID = -9082931515101720723L;
	private String userSessionCode;
	private String sessionStatus;
	private Integer sessionTime;
	private String projectCode;
	private Integer invalidCount;
	private Integer sessionMess;
	
	
	private TblDataUser tblDataUser;
	
	@OneToOne(mappedBy = "userSessionCode")
	public TblDataUser getTblDataUser() {
		return tblDataUser;
	}
	public void setTblDataUser(TblDataUser tblDataUser) {
		this.tblDataUser = tblDataUser;
	}
	
	@Id
	@Column(name="USER_SESSION_CODE") 
	public String getUserSessionCode() {
		return userSessionCode;
	}
	public void setUserSessionCode(String userSessionCode) {
		this.userSessionCode = userSessionCode;
	}
	
	
	@Column(name="SESSION_STATUS") 
	public String getSessionStatus() {
		return sessionStatus;
	}
	public void setSessionStatus(String sessionStatus) {
		this.sessionStatus = sessionStatus;
	}
	
	@Column(name="SESSION_TIME") 
	public Integer getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(Integer sessionTime) {
		this.sessionTime = sessionTime;
	}
	

	@Column(name="PROJECT_CODE") 
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	@Column(name="INVALID_COUNT")
	public Integer getInvalidCount() {
		return invalidCount;
	}
	public void setInvalidCount(Integer invalidCount) {
		this.invalidCount = invalidCount;
	}
	
	@Column(name="SESSION_MESS")
	public Integer getSessionMess() {
		return sessionMess;
	}
	public void setSessionMess(Integer sessionMess) {
		this.sessionMess = sessionMess;
	}
	
	//Join column part --------------------------------- /////
//	@OneToOne(mappedBy="USER_SESSION_CODE", cascade = CascadeType.ALL)
//	private TblDataUser tblDataUser;
//
//	public TblDataUser getTblDataUser() {
//		return tblDataUser;
//	}
//	public void setTblDataUser(TblDataUser tblDataUser) {
//		this.tblDataUser = tblDataUser;
//	}
//	
}
