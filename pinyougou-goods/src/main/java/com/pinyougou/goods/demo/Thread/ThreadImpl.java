package com.pinyougou.goods.demo.Thread;

/**
 * @author ljn
 * @date 2019/3/20.
 */
public class ThreadImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("显示Runnable接口线程");
    }

    public static void main(String[] args) {
        new Thread(new ThreadImpl()).start();
    }
}
