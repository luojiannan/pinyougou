package com.pinyougou.goods.demo.singleton;

/**
 * @author ljn
 * @date 2019/3/19.
 * 通过内部类的方式，来控制单例对象的创建时间
 */
public class Singleton6 {

    private Singleton6(){

    }

    private static class SingletonHolder{
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static final Singleton6 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
