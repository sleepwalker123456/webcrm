package com.example.oautherssoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sleepwalker
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OautherSsoServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OautherSsoServerApplication.class, args);
	}

}
