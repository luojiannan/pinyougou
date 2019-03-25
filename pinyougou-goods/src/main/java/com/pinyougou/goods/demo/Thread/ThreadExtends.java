package com.pinyougou.goods.demo.thread;

import java.util.Date;

/**
 * @author ljn
 * @date 2019/3/20.
 */
public class ThreadExtends extends Thread {

    @Override
    public void run() {
        System.out.println("第二个线程");
        while(true) {
            System.out.println("-------" + new Date() + "----------");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public static void main(String[] args) {
        ThreadExtends thread = new ThreadExtends();
        thread.start();
        try {
            sleep(10000);
        } catch (InterruptedException e) {
        }
        thread.interrupt();
    }
}
