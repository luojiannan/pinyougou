package com.pinyougou;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@MapperScan("com.pinyougou.dao.mapper")
public class PinyougouGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouGoodsApplication.class, args);
	}
}
