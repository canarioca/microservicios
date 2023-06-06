package com.microport.idea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviciosCochesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosCochesApplication.class, args);
	}

}
