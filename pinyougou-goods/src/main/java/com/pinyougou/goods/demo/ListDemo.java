package com.pinyougou.goods.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ljn
 * @date 2019/3/13.
 */
public class ListDemo {

    public static void main(String[] args) {
        String[] arr = new String[]{"one","two","three"};
        System.out.println(Arrays.toString(arr));
        List<String> list = Arrays.asList(arr);
        List<String> copyList = new ArrayList<>(list);
//        list.add("ss");
        copyList.add("four");
        copyList.forEach(s -> {
            System.out.println(s);
        });
        String[] array = new String[3];
        copyList.toArray(arr);
        System.out.println(Arrays.toString(array));
        int[] a = {1,2,3};

        int myA[];
        myA = new int[5];
    }
}
