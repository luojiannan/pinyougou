package com.pinyougou.goods.demo.singleton;

/**
 * @author ljn
 * @date 2019/3/19.
 * 恶汉式
 * 在类加载期间创建，不能控制加载时间，如果在获取过程中，要访问其他的bean，不能确保其他的bean有没有创建
 */
public class Singleton5 {

    private Singleton5(){

    }

    private final static Singleton5 instance = new Singleton5();

    public static Singleton5 getInstance () {
        return instance;
    }
}
