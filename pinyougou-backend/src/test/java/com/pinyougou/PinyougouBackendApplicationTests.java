package com.pinyougou;

import com.pinyougou.backend.redis.RedisCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PinyougouBackendApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private RedisCache redis;

	@Test
	public void test1(){
		redis.add("key", "value");
	}
	@Test
	public void test2(){
		redis.delete("key");
	}

	@Test
	public void test3(){
		String value = redis.get("key");
		System.out.println(value);
	}


}
