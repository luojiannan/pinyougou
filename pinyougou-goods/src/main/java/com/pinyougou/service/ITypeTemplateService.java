package com.pinyougou.service;

import com.github.pagehelper.Page;
import com.pinyougou.dao.entity.TypeTemplate;

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
	public List<TypeTemplate> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public Page findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TypeTemplate typeTemplate);
	
	
	/**
	 * 修改
	 */
	public void update(TypeTemplate typeTemplate);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TypeTemplate findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public Page findPage(TypeTemplate typeTemplate, int pageNum, int pageSize);
	
}
