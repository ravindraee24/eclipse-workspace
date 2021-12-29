package tml.ipmsg.xiaomi_soip_consumer_delivery_failed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableRabbit
@SpringBootApplication
public class XiaomiSoipConsumerDeliveryFailedApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(XiaomiSoipConsumerDeliveryFailedApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(XiaomiSoipConsumerDeliveryFailedApplication.class, args);
		LOGGER.info("---------------SOIP failed consumer started------------------------");
	}

}
