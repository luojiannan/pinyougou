package com.pinyougou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.dao.entity.SpecificationOption;
import com.pinyougou.dao.mapper.SpecificationOptionMapper;
import com.pinyougou.service.ISpecificationOptionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationOptionServiceImpl implements ISpecificationOptionService {

	@Autowired
	private SpecificationOptionMapper specificationOptionMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<SpecificationOption> findAll() {
		return specificationOptionMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public Page findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return  (Page<SpecificationOption>) specificationOptionMapper.selectByExample(null);
	}

	/**
	 * 增加
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void add(SpecificationOption specificationOption) {
		specificationOptionMapper.insert(specificationOption);
	}

	
	/**
	 * 修改
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SpecificationOption specificationOption){
		specificationOptionMapper.updateByPrimaryKey(specificationOption);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public SpecificationOption findOne(Long id){
		return specificationOptionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Long[] ids) {
		for(Long id:ids){
			specificationOptionMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public Page findPage(SpecificationOption specificationOption, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(SpecificationOption.class);
		Example.Criteria criteria = example.createCriteria();
		if(specificationOption!=null){
			if(StringUtils.isNotBlank(specificationOption.getOptionName())){
				criteria.andLike("optionName","%"+specificationOption.getOptionName()+"%");
			}
		}
		return (Page<SpecificationOption>)specificationOptionMapper.selectByExample(example);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void batchInsert(List<SpecificationOption> list) {
		specificationOptionMapper.insertList(list);
	}
}
