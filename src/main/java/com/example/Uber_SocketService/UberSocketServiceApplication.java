package com.example.Uber_SocketService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.example.Uber_Entity.models")
public class UberSocketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberSocketServiceApplication.class, args);
	}

}
