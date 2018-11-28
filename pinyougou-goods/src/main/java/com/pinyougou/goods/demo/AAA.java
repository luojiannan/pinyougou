package com.pinyougou.goods.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljn
 * @date 2018/11/16.
 */
public class AAA {

    private String a ;

    private String b;

    void aaa(){
        System.out.println("aaa");
    }

    public static void main(String[] args) {
        String str = "中国aadf 的111 萨bbb 菲的zz 萨菲";
        Map<Object,Integer> map = new HashMap<>();
        for (int i = 0;i<str.length();i++) {
            char c = str.charAt(i);
            if (map.get(c) == null) {
                map.put(c,1);
            } else {
                map.put(c,map.get(c) + 1);
            }
        }
        System.out.println(map);
    }
}
