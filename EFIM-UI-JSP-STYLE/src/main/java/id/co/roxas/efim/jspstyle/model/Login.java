package id.co.roxas.efim.jspstyle.model;

import java.io.Serializable;

public class Login implements Serializable{

	private static final long serialVersionUID = -7619738120563176221L;

	private String inputUserId;
	private String inputPassword;
	public String getInputUserId() {
		return inputUserId;
	}
	public void setInputUserId(String inputUserId) {
		this.inputUserId = inputUserId;
	}
	public String getInputPassword() {
		return inputPassword;
	}
	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}
	
	
}
