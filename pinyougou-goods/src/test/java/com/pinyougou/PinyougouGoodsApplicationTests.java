package com.pinyougou;

import com.pinyougou.goods.redis.GoodsRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PinyougouGoodsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	GoodsRedis goodsRedis;

	@Test
	public void tes2() {
		goodsRedis.add();
	}

	@Test
	public void test1(){
		System.out.println(goodsRedis.get());
	}

	@Test
	public void test3(){
		goodsRedis.delete();
	}


}
