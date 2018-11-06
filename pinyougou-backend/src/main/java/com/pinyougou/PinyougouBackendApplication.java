package com.pinyougou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PinyougouBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouBackendApplication.class, args);
	}
}
