package com.pinyougou.goods.demo.thread;

/**
 * @author ljn
 * @date 2019/3/22.
 * 调用synchronized修饰的方法时，当前对象被锁定
 */
public class TestSync implements Runnable {

    private Timer timer = new Timer();

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        TestSync t = new TestSync();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.setName("One");
        t2.setName("Two");
        t1.start();
        t2.start();
    }

    class Timer{
        private int num = 0;

        public synchronized void add(String name) {
                num ++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(name + ",你是第" + num + "个使用timer的线程");
        }
    }
}
