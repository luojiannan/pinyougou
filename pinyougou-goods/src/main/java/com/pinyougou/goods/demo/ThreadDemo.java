package com.pinyougou.goods.demo;

/**
 * @author ljn
 * @date 2019/3/14.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Thread t = new Thread(){
          @Override
          public void run() {
              hello();
          }
        };
        t.run();
        System.out.println("world");
        String s = "hello";
        StringBuffer sbs = new StringBuffer();
        for (int i=s.length() - 1;i>=0;i--) {
            sbs.append(s.charAt(i));
        }
        System.out.println(sbs.toString());

        StringBuilder sb = new StringBuilder(s);
        String afterReverse = sb.reverse().toString();
        System.out.println(afterReverse);
    }
    static void hello(){
        System.out.print("hello");
    }


}
