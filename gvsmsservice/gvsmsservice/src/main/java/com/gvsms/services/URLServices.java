package com.gvsms.services;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class URLServices implements URLServiceint {
	private static final Logger logger = LogManager.getLogger(URLServices.class);
	@Override
	public  String callURL(String URL,String username,String password,String from,String to,String text,String dltContentId)
	{
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("username", username);
		vars.put("password", password);
		vars.put("from", from);
		vars.put("to", to);
		vars.put("text", text);
		vars.put("dltContentId",dltContentId);
		 RestTemplate restTemplate;
		try {
			restTemplate = restTemplate();
			//String result =restTemplate.getForObject("https://api.sss.bz/smpp?username={username}&password={password}&from={from}&TEMPLATE_ID={dltContentId}&to={to}&text={text}", String.class, vars);

		String result =restTemplate.getForObject(URL, String.class, vars);
		logger.error(""+result);
		return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			return e.getMessage();
		}
		
	}
	@Override
	public String callURLGVSMS(String URL,String username,String password,String from,String to,String text,String dltContentId)
	{
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("username", username);
		vars.put("password", password);
		vars.put("from", from);
		vars.put("to", to);
		vars.put("text", text);
		vars.put("dltContentId",dltContentId);
		 RestTemplate restTemplate;
		try {
			restTemplate = restTemplate();
			//String result =restTemplate.getForObject("https://api.sss.bz/smpp?username={username}&password={password}&from={from}&TEMPLATE_ID={dltContentId}&to={to}&text={text}", String.class, vars);

		String result =restTemplate.getForObject(URL, String.class, vars);
		logger.error(""+result);
		return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
			return e.getMessage();
		}
		
	}
	public RestTemplate restTemplate() 
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

requestFactory.setHttpClient(httpClient);
RestTemplate restTemplate = new RestTemplate(requestFactory);
return restTemplate;
}
}
