package com.pinyougou.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
public class PinyougouFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouFrontendApplication.class, args);
	}

}

