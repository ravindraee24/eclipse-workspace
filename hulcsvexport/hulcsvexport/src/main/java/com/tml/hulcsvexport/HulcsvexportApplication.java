package com.tml.hulcsvexport;

import java.io.File;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.tml.hulcsvexport.dataservice.dataService;
import com.tml.hulcsvexport.model.Dataset;



@SpringBootApplication
public class HulcsvexportApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HulcsvexportApplication.class, args);
	}
	@Autowired
	private  dataService userrepo;
	@Override
	public void run(String... args) throws Exception {
	List<Dataset> s=	userrepo.InsertDataToCallback();
	System.out.println("datafor");
	for (int i = 0; i < s.size(); i++) {
		System.out.println(s.get(i).getMsisdn());
    }
	try (
            Writer writer = Files.newBufferedWriter(Paths.get("hul.csv"));
        ) {
            StatefulBeanToCsv<Dataset> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            
            beanToCsv.write(s);
            sendMailWithAttachment("ravindra.kumar1@timesinternet.in","test","ravi body","att");
        }
	}
	
	@Autowired
	private JavaMailSender mailSender;
	 
	public void sendMailWithAttachment(String to, String subject, String body, String fileToAttach) 
	{
	    MimeMessagePreparator preparator = new MimeMessagePreparator() 
	    {
	        public void prepare(MimeMessage mimeMessage) throws Exception 
	        {
	            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            mimeMessage.setFrom(new InternetAddress("admin@mobihangama.com"));
	            mimeMessage.setSubject(subject);
	            mimeMessage.setText(body);
	             
	            FileSystemResource file = new FileSystemResource(new File("hul.csv"));
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	            helper.addAttachment("hul.csv", file);
	        }
	    };
	     
	    try {
	        mailSender.send(preparator);
	    }
	    catch (MailException ex) {
	        // simply log it and go on...
	        System.err.println(ex.getMessage());
	    }
	}
}
