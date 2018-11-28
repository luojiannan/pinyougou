package com.pinyougou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient
@MapperScan("com.pinyougou.goods.dao.mapper")
@EnableSwagger2
public class PinyougouGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouGoodsApplication.class, args);
	}
}
