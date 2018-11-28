package com.pinyougou.dto;

import java.util.List;

/**
 * @author ljn
 * 规格
 */

public class SpecificationDTO {

    private Long id;

    /**
     * 名称
     */
    private String specName;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 规格选项
     */
    private List<SpecificationOptionDTO> specificationOptionList;

    public List<SpecificationOptionDTO> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<SpecificationOptionDTO> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return spec_name - 名称
     */
    public String getSpecName() {
        return specName;
    }

    /**
     * 设置名称
     *
     * @param specName 名称
     */
    public void setSpecName(String specName) {
        this.specName = specName;
    }
}