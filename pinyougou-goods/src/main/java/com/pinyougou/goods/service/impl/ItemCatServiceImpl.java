package com.pinyougou.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.goods.dao.entity.ItemCat;
import com.pinyougou.goods.dao.mapper.ItemCatMapper;
import com.pinyougou.goods.service.IItemCatService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class ItemCatServiceImpl implements IItemCatService {

	@Autowired
	private ItemCatMapper itemCatMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<ItemCat> findAll() {
		return itemCatMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public Page findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return (Page<ItemCat>) itemCatMapper.selectByExample(null);
	}

	/**
	 * 增加
	 */
	@Override
	public void add(ItemCat itemCat) {
		itemCatMapper.insert(itemCat);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(ItemCat itemCat){
		itemCatMapper.updateByPrimaryKey(itemCat);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public ItemCat findOne(Long id){
		return itemCatMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Long[] ids) {
		if (ArrayUtils.isEmpty(ids)) {
			throw new RuntimeException("请选中要删除的商品分类");
		}
		for(Long id:ids){
			ItemCat itemCat = itemCatMapper.selectByPrimaryKey(id);
			if (itemCat == null) {
				throw new RuntimeException("不存在此id");
			}
			List<ItemCat> list = this.findByParentId(id);
			if (!CollectionUtils.isEmpty(list)) {
				throw new RuntimeException(itemCat.getName() + ":商品分类存在子级商品分类，请先删除子级分类");
			}
		}
		List<Long> list = Arrays.asList(ids);
		itemCatMapper.batchDelete(list);
	}
	
	
	@Override
	public Page findPage(ItemCat itemCat, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(ItemCat.class);
		Example.Criteria criteria = example.createCriteria();
		if(itemCat!=null){
			if(StringUtils.isNotBlank(itemCat.getName())){
				criteria.andLike("name","%"+itemCat.getName()+"%");
			}
		}
		return (Page<ItemCat>)itemCatMapper.selectByExample(example);
	}

	@Override
	public List<ItemCat> findByParentId(Long parentId) {
		Example example = new Example(ItemCat.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("parentId", parentId);
		return itemCatMapper.selectByExample(example);
	}
}
