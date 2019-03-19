package com.pinyougou.goods.demo.singleton;

/**
 * @author ljn
 * @date 2019/3/19.
 * volatile 可以防止指令重排序
 */
public class Singleton4 {

    private Singleton4() {
    }

    private static volatile Singleton4 instance;

    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
