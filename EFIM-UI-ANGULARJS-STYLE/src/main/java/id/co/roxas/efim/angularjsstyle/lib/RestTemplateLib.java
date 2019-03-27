package id.co.roxas.efim.angularjsstyle.lib;

import java.io.IOException;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import Share.WsResponse;
import id.co.roxas.efim.angularjsstyle.configuration.AppConfig;

@Service("restTemplateLib")
public class RestTemplateLib extends MapperWs implements Serializable{

	@Autowired
	private AppConfig appConfig;
	
	@Autowired
	private Environment env;
	
	private static final long serialVersionUID = 1564074110921000829L;
	
	private String componentCoreScanner() {
		String url = env.getProperty(appConfig.getCoreMapper());
		System.out.println("url yang terpakai : " + url);
		return url;
	}
	
	public WsResponse getResultWs(String url, Object body, String method, String... paramQuery) {
		WsResponse wsResponse = new WsResponse();
		
		MultiValueMap<String, Object> header = new LinkedMultiValueMap();
//		SecurityPr spr = new SecurityPr();
//		header.add("ip", spr.getIpAddress());
//		header.add("mac", spr.getMacAddress());
//		header.add("sn", spr.getSerialNumber());
		
		String finalparamQuery = "";
		if(paramQuery!=null) {
		if(paramQuery.length!=0) {
			   if(paramQuery.length != 0){
			   finalparamQuery = "?";
			   for (int i = 0; i < paramQuery.length; i++) {
				 finalparamQuery += paramQuery[i];
				 if(i<paramQuery.length-1){
					 finalparamQuery += "&"; 
				 }
			   }
			   }
		}
		}
		
		String resultApi = "";
		if(method.equalsIgnoreCase("POST")) {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity httpEntity = new HttpEntity(body,header);
			System.out.println(new Gson().toJson(body));
			System.out.println(componentCoreScanner()+url+finalparamQuery);
			resultApi = restTemplate.exchange(componentCoreScanner()+url+finalparamQuery, HttpMethod.POST,httpEntity,String.class).getBody();
			System.err.println("hasil : " + resultApi);
		}
		else if(method.equalsIgnoreCase("GET")) {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity httpEntity = new HttpEntity(null,header);
			resultApi = restTemplate.exchange(componentCoreScanner()+url+finalparamQuery, HttpMethod.GET,httpEntity,String.class).getBody();
		}
	
		System.err.println("hasilnya sesungguhnya adalah " + resultApi);
		
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			wsResponse = om.readValue(resultApi, WsResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return wsResponse;
	}
	
	public WsResponse getResultWsSolr(String url, Object body, String method, String... paramQuery) {
		WsResponse wsResponse = new WsResponse();
		
		MultiValueMap<String, Object> header = new LinkedMultiValueMap();
//		SecurityPr spr = new SecurityPr();
//		header.add("ip", spr.getIpAddress());
//		header.add("mac", spr.getMacAddress());
//		header.add("sn", spr.getSerialNumber());
		
		String finalparamQuery = "";
		if(paramQuery!=null) {
		if(paramQuery.length!=0) {
			   if(paramQuery.length != 0){
			   finalparamQuery = "?";
			   for (int i = 0; i < paramQuery.length; i++) {
				 finalparamQuery += paramQuery[i];
				 if(i<paramQuery.length){
					 finalparamQuery += "&"; 
				 }
			   }
			   }
		}
		}
		
		String resultApi = "";
		if(method.equalsIgnoreCase("POST")) {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity httpEntity = new HttpEntity(body,header);
			resultApi = restTemplate.exchange(appConfig.getHeadUrlSolr()+url+finalparamQuery, HttpMethod.POST,httpEntity,String.class).getBody();
			System.err.println("hasil : " + resultApi);
		}
		else if(method.equalsIgnoreCase("GET")) {
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity httpEntity = new HttpEntity(null,header);
			resultApi = restTemplate.exchange(appConfig.getHeadUrlSolr()+url+finalparamQuery, HttpMethod.GET,httpEntity,String.class).getBody();
		}
	
		System.err.println("hasilnya sesungguhnya adalah " + resultApi);
		
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			wsResponse = om.readValue(resultApi, WsResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return wsResponse;
	}

}
