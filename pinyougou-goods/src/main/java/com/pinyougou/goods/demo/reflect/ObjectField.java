package com.pinyougou.goods.demo.reflect;

import com.pinyougou.goods.controller.BrandController;
import com.pinyougou.goods.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ljn
 * @date 2019/3/26.
 */
public class ObjectField {

    public static void main(String[] args) {
        Class<BrandServiceImpl> mapperClass = BrandServiceImpl.class;
        BrandServiceImpl brandService = null;
        try {
            brandService = mapperClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Map<Class<?>, Object> beanMap = new HashMap<>();
        beanMap.put(mapperClass, brandService);
        Class<BrandController> aClass = BrandController.class;
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Class<?> fieldType = field.getType();
                System.out.println(fieldType);
                Object o = beanMap.get(fieldType);
                System.out.println(o);
            }
        }
    }
}
