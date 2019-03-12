package id.co.roxas.efim.jspstyle.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
 
	@Value("${coreMapper}")
	private String coreMapper;
	
	@Value("${projectCode}")
	private String projectCode;
	
	@Value("${userGmailEfim}")
	private String userGmailEfim;
	
	@Value("${passGmailEfim}")
	private String passGmailEfim;
	
	@Value("${headUrlHibernate}")
	private String headUrlHibernate;
	
	@Value("${headUrlMybatis}")
	private String headUrlMybatis;
	
	@Value("${headUrlSolr}")
	private String headUrlSolr;
	

	public String getCoreMapper() {
		return coreMapper;
	}

	public void setCoreMapper(String coreMapper) {
		this.coreMapper = coreMapper;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getUserGmailEfim() {
		return userGmailEfim;
	}

	public void setUserGmailEfim(String userGmailEfim) {
		this.userGmailEfim = userGmailEfim;
	}

	public String getPassGmailEfim() {
		return passGmailEfim;
	}

	public void setPassGmailEfim(String passGmailEfim) {
		this.passGmailEfim = passGmailEfim;
	}

	public String getHeadUrlHibernate() {
		return headUrlHibernate;
	}

	public void setHeadUrlHibernate(String headUrlHibernate) {
		this.headUrlHibernate = headUrlHibernate;
	}

	public String getHeadUrlMybatis() {
		return headUrlMybatis;
	}

	public void setHeadUrlMybatis(String headUrlMybatis) {
		this.headUrlMybatis = headUrlMybatis;
	}

	public String getHeadUrlSolr() {
		return headUrlSolr;
	}

	public void setHeadUrlSolr(String headUrlSolr) {
		this.headUrlSolr = headUrlSolr;
	}
	
	
	
}
