package id.co.roxas.efim.lib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
   
	@Value("${paging.number}")
	private int pagingNumber;

	public int getPagingNumber() {
		return pagingNumber;
	}

	public void setPagingNumber(int pagingNumber) {
		this.pagingNumber = pagingNumber;
	}


	
	
}
