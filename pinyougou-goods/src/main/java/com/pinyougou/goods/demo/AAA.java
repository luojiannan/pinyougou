package com.pinyougou.goods.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List list = new ArrayList<>();
        list.add("1");
        List<?> list3 = new ArrayList<>();
//        list3.add(new Object());
//        list3 = list;
        System.out.println(list);
        List list2 = new ArrayList<>();
        list2.add("2");
        List list1 = list = list2;
        if ((list = list2) == null) {

        }

        int a ;
        int b = a = 1;

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

    public void a() {
        System.out.println("222");
    }

}
