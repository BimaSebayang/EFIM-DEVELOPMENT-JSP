package id.co.roxas.efim.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
   
	@Value("${paging.number}")
	private String pagingNumber;

	public String getPagingNumber() {
		return pagingNumber;
	}

	public void setPagingNumber(String pagingNumber) {
		this.pagingNumber = pagingNumber;
	}
	
	
}
