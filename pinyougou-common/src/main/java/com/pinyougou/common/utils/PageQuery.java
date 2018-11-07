package com.pinyougou.common.utils;


import com.pinyougou.common.contants.PageContant;

/**
 * @author Link
 */
public class PageQuery {
    private Integer page = PageContant.PAGE;

    private Integer size = PageContant.SIZE;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        if (size < PageContant.SIZE) {
            this.size = size;
        }
    }
}
