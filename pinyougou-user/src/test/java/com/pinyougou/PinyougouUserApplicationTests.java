package com.pinyougou;

import com.pinyougou.user.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PinyougouUserApplicationTests {

	@Test
	public void contextLoads() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		UserServiceImpl service = new UserServiceImpl();
		Class<UserServiceImpl> cls = UserServiceImpl.class;
		Method[] declaredMethods = cls.getDeclaredMethods();
		Method method1 = cls.getMethod("findByName", String.class);
		Object sunwukong = method1.invoke(service, "sunwukong");
		System.out.println(sunwukong);


	}

}
