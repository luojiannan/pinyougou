package com.pinyougou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @EnableEurekaServer eureka服务注解
 */

@SpringBootApplication
@EnableEurekaServer
public class PinyougouEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouEurekaApplication.class, args);
	}
}
