package com.pinyougou.goods.demo.Thread;

/**
 * @author ljn
 * @date 2019/3/22.
 * 主动让出时间片，给优先级高或优先级相等的线程
 */
public class TestYield extends Thread {

    public TestYield(String s) {
        super(s);
    }

    public static void main(String[] args) {
        TestYield t1 = new TestYield("t1");
        TestYield t2 = new TestYield("t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++) {
            System.out.println(getName() + ":"+i);
            if (i%10==0) {
                yield();
            }
        }
    }
}
