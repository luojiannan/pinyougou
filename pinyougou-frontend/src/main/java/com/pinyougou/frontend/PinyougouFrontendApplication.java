package com.pinyougou.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableCircuitBreaker //服务熔断
//@EnableHystrix  //服务降级
//@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
@SpringCloudApplication
public class PinyougouFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouFrontendApplication.class, args);
	}

}



