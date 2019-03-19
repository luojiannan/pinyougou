package com.pinyougou.goods.demo.singleton;

/**
 * @author ljn
 * @date 2019/3/19.
 * 除了第一个访问，其他的都需要等待前面的完成getInstance，影响效率
 */
public class Singleton2 {

    private Singleton2(){

    }

    private static Singleton2 instance;

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
