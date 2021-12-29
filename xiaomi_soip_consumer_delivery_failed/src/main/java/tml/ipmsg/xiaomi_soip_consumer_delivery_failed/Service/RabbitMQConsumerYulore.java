package tml.ipmsg.xiaomi_soip_consumer_delivery_failed.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.model.DlrModel;
import tml.ipmsg.xiaomi_soip_consumer_delivery_failed.IService.*;
import tml.ipmsg.xiaomi_soip_consumer.entity.Message;

@Service
public class RabbitMQConsumerYulore {
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private IDlrService cpDlrService;
	@Value("${badreq.rabbitmq.exchange}")
	private String exchange;
	
	
	@RabbitListener(queues = "queue.yuloreerror")
	public void recievedMessage(Message webRequest) throws IOException 
	{ 
		DlrModel cpDlr = new DlrModel();
		cpDlr.setTransactionid(webRequest.getMsgId());
		cpDlr.setRecieptid("");
		cpDlr.setCorelationid(URLEncoder.encode(webRequest.getBizExtra()));
		cpDlr.setRecipient(webRequest.getPhone());
		cpDlr.setSender(webRequest.getBizNum());
		cpDlr.setDescription("");
		cpDlr.setTotalpdu("0");
		cpDlr.setMessage(webRequest.getContent());
		cpDlr.setDeliverystatus(webRequest.getDelivery_status());
		String timestamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format( new java.util.Date());
		cpDlr.setDeliverydt(timestamp );
		cpDlr.setSubmitdt(timestamp);		
		cpDlr.setAccount("xiomidlr");
		cpDlr.setSource("yulore");
		/*if(deliverydt != null && (deliverydt.length() >= 10))
			cpDlr.setDeliverydate(deliverydt.substring(0, 10));*/
		
		int insertStatus = cpDlrService.save(cpDlr);
		LOGGER.info("insertstatus::"+insertStatus);
		
       // String proResponse=messageSender.SendmessageToPro(webRequest);
		LOGGER.info("proResponse --- ");
		
		//MessageDao.
		
	}
	
}
