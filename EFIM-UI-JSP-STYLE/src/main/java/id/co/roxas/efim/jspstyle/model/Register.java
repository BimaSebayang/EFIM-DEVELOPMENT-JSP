package id.co.roxas.efim.jspstyle.model;

import java.io.Serializable;

public class Register implements Serializable{

	private static final long serialVersionUID = -1515731832775292324L;

	private String registerUserName;
	private String registerUserId;
	private String registerUserMail;
	private String registerUserPhone;
	private String registerUserPassword;
	private String confirmUserRegisterPassword;
	public String getRegisterUserName() {
		return registerUserName;
	}
	public void setRegisterUserName(String registerUserName) {
		this.registerUserName = registerUserName;
	}
	public String getRegisterUserId() {
		return registerUserId;
	}
	public void setRegisterUserId(String registerUserId) {
		this.registerUserId = registerUserId;
	}
	public String getRegisterUserMail() {
		return registerUserMail;
	}
	public void setRegisterUserMail(String registerUserMail) {
		this.registerUserMail = registerUserMail;
	}
	public String getRegisterUserPhone() {
		return registerUserPhone;
	}
	public void setRegisterUserPhone(String registerUserPhone) {
		this.registerUserPhone = registerUserPhone;
	}
	public String getRegisterUserPassword() {
		return registerUserPassword;
	}
	public void setRegisterUserPassword(String registerUserPassword) {
		this.registerUserPassword = registerUserPassword;
	}
	public String getConfirmUserRegisterPassword() {
		return confirmUserRegisterPassword;
	}
	public void setConfirmUserRegisterPassword(String confirmUserRegisterPassword) {
		this.confirmUserRegisterPassword = confirmUserRegisterPassword;
	}
	
	
	
}
