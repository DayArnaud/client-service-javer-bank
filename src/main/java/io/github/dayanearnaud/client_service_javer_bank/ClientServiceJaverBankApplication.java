package io.github.dayanearnaud.client_service_javer_bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientServiceJaverBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceJaverBankApplication.class, args);
	}

}
