package com.pinyougou.service;

import com.github.pagehelper.Page;
import com.pinyougou.dao.entity.GoodsDesc;

import java.util.List;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface IGoodsDescService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<GoodsDesc> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public Page findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(GoodsDesc goodsDesc);
	
	
	/**
	 * 修改
	 */
	public void update(GoodsDesc goodsDesc);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public GoodsDesc findOne(Long id);
	
	
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
	public Page findPage(GoodsDesc goodsDesc, int pageNum, int pageSize);
	
}
