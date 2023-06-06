package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class MicroserviciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosApplication.class, args);
	}

}
