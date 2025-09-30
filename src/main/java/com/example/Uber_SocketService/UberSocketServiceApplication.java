package com.example.Uber_SocketService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UberSocketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberSocketServiceApplication.class, args);
	}

}
