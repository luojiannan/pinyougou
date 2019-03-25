package com.pinyougou.goods.demo.thread;

/**
 * @author ljn
 * @date 2019/3/25.
 */
public class TestThreadLocal {

    private static ThreadLocal<Long> threadId = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return super.initialValue();
        }
    };
    private static ThreadLocal<String> threadName = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "aaa";
        }
    };

    public static void test() {
        threadId.set(Thread.currentThread().getId());
        threadName.set(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        TestThreadLocal test = new TestThreadLocal();
        test();
        System.out.println(threadId.get());
        System.out.println(threadName.get());
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                test();
                System.out.println(threadId.get());
                System.out.println(threadName.get());
            }
        };
        thread1.start();
        System.out.println(threadId.get());
        System.out.println(threadName.get());
    }
}
