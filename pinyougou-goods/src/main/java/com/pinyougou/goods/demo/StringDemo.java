package com.pinyougou.goods.demo;

import java.lang.reflect.Field;

/**
 * @author ljn
 * @date 2019/3/15.
 */
public class StringDemo {

    public static void main(String[] args) throws IllegalAccessException {

        String a = "hello2";
        Class<String> aClass = (Class<String>) a.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for(Field field :fields) {
            field.setAccessible(true);
            if (field.getName().equals("value")) {
                System.out.println(field);
                char[] chars = (char[])field.get(a);
                chars[0] = 'a';
            }
        }
        System.out.println(a);
    }
}
