package com.pinyougou.goods.demo;

import java.lang.reflect.Method;

/**
 * @author ljn
 * @date 2018/11/16.
 */
public class ReflectDemo extends AAA {

    public static void main(String[] args) {
        new ReflectDemo().test();
    }

    public void test() {
        //getClass()是从Object继承来的方法，返回结果是当前运行类的类对象  在Object的API当中有说过
        Class<? extends Object> aClass = super.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        String name = aClass.getName();
        System.out.println(name);
        //获得父类类对象使用getSuperClass()方法
        name = aClass.getSuperclass().getName();
        System.out.println(name);

        int length = new int[]{1}.length;
    }
}
