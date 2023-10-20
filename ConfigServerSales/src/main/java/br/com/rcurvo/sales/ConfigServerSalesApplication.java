package br.com.rcurvo.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerSalesApplication.class, args);
	}

}
