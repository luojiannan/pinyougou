package com.pinyougou.goods.service;

import com.github.pagehelper.Page;
import com.pinyougou.goods.dao.entity.TypeTemplate;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ITypeTemplateService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<TypeTemplate> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	Page findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(TypeTemplate typeTemplate);
	
	
	/**
	 * 修改
	 */
	void update(TypeTemplate typeTemplate);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	TypeTemplate findOne(Long id);
	
	
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
	Page findPage(TypeTemplate typeTemplate, int pageNum, int pageSize);

}
