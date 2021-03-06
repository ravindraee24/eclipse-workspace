package com.gvsms.gvsmsservice;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.gvsms.services.DBService;
import com.gvsms.services.URLServices;

@SpringBootApplication
@ComponentScan({"com.gvsms.services"})
@EntityScan("com.gvsms.services")
public class GvsmsserviceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GvsmsserviceApplication.class, args);
	}
	@Autowired
	DBService dbservice;
	@Autowired
	URLServices urlservice;
	@Override
	public void run(String... args) throws Exception {
		DBService dbservice =new DBService();
		List<Object> objdata	=dbservice.insercallbackboot();
	 System.out.println("====================xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+objdata);
	String Resp= urlservice.callURLGVSMS("https://google.com", "username", "password", "from", "to", "text", "dltContentId");
	//String ACrespon=urlservice.callURL(URL, username, password, from, to, text, dltContentId) ;
	//dbservice.insercallbackboot(_transactionId_, _recieptId_, _recpient_, _sender_, _description_, _totalPdu_, _message_, _deliverystatus_, _deliverydt_, _submitdt_);
	System.out.println("===================="+Resp);
	}
	}

