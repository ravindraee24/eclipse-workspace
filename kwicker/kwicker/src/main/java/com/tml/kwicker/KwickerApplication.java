package com.tml.kwicker;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.CommandLineRunner;

import com.tml.kwicker.model.DataModel;
import com.tml.kwicker.service.DatabaseService;

@SpringBootApplication
public class KwickerApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(KwickerApplication.class, args);
		
	}
	
	@Autowired
	private  DatabaseService userrepo;
	@Override
	public void run(String... args) throws Exception {
	List<DataModel> s=	userrepo.Selectdata("", "");
	System.out.println("datafor"+s);
	for (int i = 0; i < s.size(); i++) {
		userrepo.InsertDataToCallback(s.get(i).getMessage_id(),s.get(i).getRecpient(), s.get(i).getRecpient(), s.get(i).getSender_name(),s.get(i).getDescription(), s.get(i).getMessage_pdu(), "toolCallback", s.get(i).getDlr_state(), s.get(i).getDone_date(), s.get(i).getSubmission_date());
    }
	}
}
