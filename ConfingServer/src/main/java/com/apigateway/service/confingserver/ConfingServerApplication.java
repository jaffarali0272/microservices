package com.apigateway.service.confingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfingServerApplication.class, args);
	}

}
