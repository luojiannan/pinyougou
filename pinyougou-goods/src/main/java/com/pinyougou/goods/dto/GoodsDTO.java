package com.pinyougou.goods.dto;

import com.pinyougou.goods.dao.entity.Goods;
import com.pinyougou.goods.dao.entity.GoodsDesc;
import com.pinyougou.goods.dao.entity.Item;

import java.util.List;

/**
 * @author ljn
 * 商品
 */
public class GoodsDTO {

    private Goods goods;

    private GoodsDesc goodsDesc;

    private List<Item> itemList;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsDesc getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(GoodsDesc goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}