package id.co.roxas.efim.entity.owner.master;

import java.io.Serializable;

//@Access(AccessType.FIELD)
public class TblSessionUser implements Serializable{

	private static final long serialVersionUID = 7980182772042690835L;
	private String userSessionCode;
	private String sessionStatus;
	private Integer sessionTime;
	private String projectCode;
	private Integer invalidCount;
	private Integer sessionMess;
	public String getUserSessionCode() {
		return userSessionCode;
	}
	public void setUserSessionCode(String userSessionCode) {
		this.userSessionCode = userSessionCode;
	}
	public String getSessionStatus() {
		return sessionStatus;
	}
	public void setSessionStatus(String sessionStatus) {
		this.sessionStatus = sessionStatus;
	}
	public Integer getSessionTime() {
		return sessionTime;
	}
	public void setSessionTime(Integer sessionTime) {
		this.sessionTime = sessionTime;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public Integer getInvalidCount() {
		return invalidCount;
	}
	public void setInvalidCount(Integer invalidCount) {
		this.invalidCount = invalidCount;
	}
	public Integer getSessionMess() {
		return sessionMess;
	}
	public void setSessionMess(Integer sessionMess) {
		this.sessionMess = sessionMess;
	}
	
	 
}
