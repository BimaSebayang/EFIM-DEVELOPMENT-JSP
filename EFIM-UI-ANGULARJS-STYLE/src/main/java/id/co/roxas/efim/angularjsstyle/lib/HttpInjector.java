package id.co.roxas.efim.angularjsstyle.lib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpInjector {
     private HttpServletRequest request;
     private HttpSession session;
      
	public HttpInjector(HttpServletRequest request, HttpSession session) {
		super();
		this.request = request;
		this.session = session;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public HttpSession getSession() {
		return session;
	}
     
     
}
