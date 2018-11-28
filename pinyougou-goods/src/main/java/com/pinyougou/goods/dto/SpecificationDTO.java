package com.pinyougou.goods.dto;

import com.pinyougou.goods.dao.entity.Specification;

import java.util.List;

/**
 * @author ljn
 * 规格
 */

public class SpecificationDTO {

    private Specification specification;

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
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
}