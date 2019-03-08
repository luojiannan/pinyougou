package com.pinyougou.goods.demo;

import com.pinyougou.goods.dao.entity.Goods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 实现list多字段排序
 * @author ljn
 * @date 2019/3/8.
 */
public class MyComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Goods goods1= (Goods) o1;
        Goods goods2= (Goods) o2;
        if (goods1.getGoodsName().compareTo(goods2.getGoodsName()) != 0) {
            return goods1.getGoodsName().compareTo(goods2.getGoodsName());
        } else if (goods1.getCaption().compareTo(goods2.getCaption()) != 0){
            return goods1.getCaption().compareTo(goods2.getCaption());
        } else {
            return goods1.getPrice().compareTo(goods2.getPrice());
        }
    }

    public static void main(String[] args) {
        Goods goods1 = new Goods("苹果", "红富士", new BigDecimal(2.6));
        Goods goods2 = new Goods("苹果", "红富士", new BigDecimal(2.6));
        Goods goods3 = new Goods("苹果", "烟台", new BigDecimal(2.5));
        Goods goods4 = new Goods("橘子", "山西", new BigDecimal(2.6));
        Goods goods5 = new Goods("橘子", "江西", new BigDecimal(2.6));
        Goods goods6 = new Goods("橘子", "红富士", new BigDecimal(2.5));
        Goods goods7 = new Goods("桃", "红富士", new BigDecimal(5));
        Goods goods8 = new Goods("桃", "红富士", new BigDecimal(7));
        Goods goods9 = new Goods("桃", "红富士", new BigDecimal(8));
        Goods goods10 = new Goods("梨", "新疆", new BigDecimal(2.6));
        Goods goods11 = new Goods("梨", "伊犁", new BigDecimal(2.6));
        Goods goods12 = new Goods("梨", "红富士", new BigDecimal(2.5));
        List<Goods> list = new ArrayList<>();
        list.add(goods1);
        list.add(goods2);
        list.add(goods3);
        list.add(goods4);
        list.add(goods5);
        list.add(goods6);
        list.add(goods7);
        list.add(goods8);
        list.add(goods9);
        list.add(goods10);
        list.add(goods11);
        list.add(goods12);
        Collections.sort(list, new MyComparator());
        for (Goods goods: list) {
            System.out.println(goods);

        }
    }
}
