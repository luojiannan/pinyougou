package com.pinyougou.backend.dto;

import java.util.List;

/**
 * @author ljn
 * 商品
 */
public class GoodsDTO {

    private Goods goods;

    private GoodsDescDTO goodsDesc;

    private List<ItemDTO> itemList;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsDescDTO getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(GoodsDescDTO goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDTO> itemList) {
        this.itemList = itemList;
    }
}