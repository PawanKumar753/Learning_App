package com.app.internship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class InternshipApplication {

	private final static Logger log = LoggerFactory.getLogger(InternshipApplication.class);
	public static void main(String[] args) {
		log.info("Internship-service started");
		SpringApplication.run(InternshipApplication.class, args);
	}

}
