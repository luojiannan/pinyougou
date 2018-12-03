package com.pinyougou.goods.service;

import com.github.pagehelper.Page;
import com.pinyougou.goods.dao.entity.Specification;
import com.pinyougou.goods.dto.SpecificationDTO;

import java.util.List;
import java.util.Map;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ISpecificationService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<Specification> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	Page findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(SpecificationDTO specificationDTO);
	
	
	/**
	 * 修改
	 */
	void update(SpecificationDTO specification);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SpecificationDTO findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(List<Long> ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	Page findPage(Specification specification, int pageNum, int pageSize);

	List<Map> selectOptionList();
	
}
