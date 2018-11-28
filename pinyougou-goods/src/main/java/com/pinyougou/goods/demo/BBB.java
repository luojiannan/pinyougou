package com.pinyougou.goods.demo;

import java.util.*;

public class BBB {
    public static void main(String[] args) {

        String s = "abcabcbb";
        int length = s.length();
        Map<Object,Integer> map = new HashMap<>();
        for (int i = 0;i<length;i++) {
            map.put(s.charAt(i),i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<length;i++) {
            for (int j=i+1;j<length;j++) {
                if (s.charAt(i)==s.charAt(j)) {
                    list.add(j-i);
                    break;
                }else {
                    list.add(j-i+1);
                }
            }
        }
        if(map.size() == length) {
            list.add(length);
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
    }
}