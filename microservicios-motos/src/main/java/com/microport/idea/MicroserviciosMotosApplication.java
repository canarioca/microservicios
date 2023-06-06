package com.microport.idea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviciosMotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosMotosApplication.class, args);
	}

}
