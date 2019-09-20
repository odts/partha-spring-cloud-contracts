package io.parth.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContractConsumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContractConsumerServiceApplication.class, args);
	}

}
