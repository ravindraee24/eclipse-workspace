package com.gvsms.services;

public interface URLServiceint {
	public String	callURL(String URL,String username,String password,String from,String to,String text,String dltContentId);
	public String	callURLGVSMS(String URL,String username,String password,String from,String to,String text,String dltContentId);
}
