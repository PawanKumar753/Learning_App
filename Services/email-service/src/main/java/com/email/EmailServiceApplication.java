package com.email;

import com.email.Services.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class EmailServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(EmailServiceApplication.class);

	public static void main(String[] args) {
		log.info("In email-service");
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
