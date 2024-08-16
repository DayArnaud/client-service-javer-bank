package io.github.dayanearnaud.client_service_javer_bank;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Client Service Javer Bank",
				description = "Serviço client do Javer Bank que atua como intermediário entre o usuário final da aplicação e o backend. Faz requisições à API da app2 (Manager Service Javer Bank), processa as respostas e facilita a manipulação e visualização dos dados de clientes.",
				version = "1"
		)
)
public class ClientServiceJaverBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceJaverBankApplication.class, args);
	}

}
