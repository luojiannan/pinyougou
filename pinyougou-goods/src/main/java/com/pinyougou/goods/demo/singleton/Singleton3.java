package com.pinyougou.goods.demo.singleton;

/**
 * @author ljn
 * @date 2019/3/19.
 * 双重检查
 * 存在指令重排序的问题
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static Singleton3 instance;

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
