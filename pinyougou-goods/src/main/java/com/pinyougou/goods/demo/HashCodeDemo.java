package com.pinyougou.goods.demo;

/**
 * @author ljn
 * @date 2019/3/12.
 */
public class HashCodeDemo {

    public static void main(String[] args) {
        //hashCode()相等即两个键值对的哈希值相等，然而哈希值相等，并不一定能得出键值对相等。
        String a = "通话";
        String b = "重地";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
        long round = Math.round(-1.6);
        System.out.println(round);

    }
}
