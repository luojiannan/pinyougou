package com.pinyougou.goods.service;

import com.github.pagehelper.Page;
import com.pinyougou.goods.dao.entity.Seller;

import java.util.List;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface ISellerService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Seller> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public Page findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Seller seller);
	
	
	/**
	 * 修改
	 */
	public void update(Seller seller);
	

	/**
	 * 根据ID获取实体
	 * @param sellerId
	 * @return
	 */
	public Seller findOne(String sellerId);
	
	
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
	public Page findPage(Seller seller, int pageNum, int pageSize);
	
}
