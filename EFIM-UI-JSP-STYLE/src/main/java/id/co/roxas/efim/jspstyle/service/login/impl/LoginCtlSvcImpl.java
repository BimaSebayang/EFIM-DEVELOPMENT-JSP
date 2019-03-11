package id.co.roxas.efim.jspstyle.service.login.impl;

import org.springframework.stereotype.Service;

import id.co.roxas.efim.jspstyle.service.login.LoginCtlSvc;

@Service("loginCtlSvc")
public class LoginCtlSvcImpl extends LoginCtlSvc{

	@Override
	public void forgot() {
		System.out.println("di forgot");
	}

	@Override
	public void headLogin() {
		System.out.println("di headLogin");
	}

	@Override
	public void headRegister() {
		System.out.println("di headRegister");
	}

	@Override
	public void headForgot() {
		System.out.println("di headForgot");
	}

	@Override
	public void login() {
		System.out.println("di login");
	}

	@Override
	public void Register() {
		System.out.println("di register");
	}
    
	
}
