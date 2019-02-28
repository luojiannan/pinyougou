package com.pinyougou.goods.demo;

import com.pinyougou.goods.annotation.AccessLimit;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ljn
 * @date 2018/11/16.
 */
public class ReflectDemo extends AAA {

    public static void main(String[] args) {
        Class<? extends ReflectDemo> aClass = new ReflectDemo().getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(AccessLimit.class)) {
                field.setAccessible(true);
                AccessLimit annotation = field.getAnnotation(AccessLimit.class);
                System.out.println(annotation.value());
                System.out.println(annotation.id());
            }
        }

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

    @AccessLimit(value="水杯")
    private String name;

    @AccessLimit(id=4)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
