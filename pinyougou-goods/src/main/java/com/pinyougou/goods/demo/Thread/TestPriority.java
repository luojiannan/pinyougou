package com.pinyougou.goods.demo.thread;

/**
 * @author ljn
 * @date 2019/3/22.
 * 可以用priority设置线程优先级，优先级高的得到的cpu时间片的几率大
 */
public class TestPriority extends Thread {

    public TestPriority(String s) {
        super(s);
    }

    @Override
    public void run() {
        for (int i = 0;i<1000;i++) {
            System.out.println(getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        TestPriority t1 = new TestPriority("One");
        TestPriority t2 = new TestPriority("Two");
        t1.setPriority(Thread.NORM_PRIORITY + 3);
        t1.start();
        t2.start();
    }
}
