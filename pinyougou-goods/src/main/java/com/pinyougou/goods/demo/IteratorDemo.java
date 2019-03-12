package com.pinyougou.goods.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author ljn
 * @date 2019/3/11.
 */
public class IteratorDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            String s = it.next();
            if (s.equals("b")) {
                it.remove();
            }
        }
//        ListIterator 还可以增加元素，反向遍历，定位下标
        ListIterator<String> listIt = list.listIterator();
        while(listIt.hasNext()) {
            String s = listIt.next();
            if  (s.equals("a")) {
                listIt.add("b");
            }
        }

    }
}
