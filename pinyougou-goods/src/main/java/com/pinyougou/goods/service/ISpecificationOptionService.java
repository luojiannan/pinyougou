package com.pinyougou.goods.service;

import com.github.pagehelper.Page;
import com.pinyougou.goods.dao.entity.SpecificationOption;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ISpecificationOptionService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<SpecificationOption> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	Page findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(SpecificationOption specificationOption);
	
	
	/**
	 * 修改
	 */
	void update(SpecificationOption specificationOption);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	SpecificationOption findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	Page findPage(SpecificationOption specificationOption, int pageNum, int pageSize);

	/**
	 * 批量插入
	 * @param list
     */
	void batchInsert(List<SpecificationOption> list);
	
}
