package com.pinyougou.service;

import com.github.pagehelper.Page;
import com.pinyougou.dao.entity.Item;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface IItemService {

	/**
	 * 返回全部列表
	 * @return
	 */
	List<Item> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	Page findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	void add(Item item);
	
	
	/**
	 * 修改
	 */
	void update(Item item);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	Item findOne(Long id);
	
	
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
	Page findPage(Item item, int pageNum, int pageSize);
	
}
