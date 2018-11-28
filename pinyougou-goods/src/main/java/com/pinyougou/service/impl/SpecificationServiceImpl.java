package com.pinyougou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.dao.entity.Specification;
import com.pinyougou.dao.entity.SpecificationOption;
import com.pinyougou.dao.mapper.SpecificationMapper;
import com.pinyougou.dto.SpecificationDTO;
import com.pinyougou.dto.SpecificationOptionDTO;
import com.pinyougou.service.ISpecificationOptionService;
import com.pinyougou.service.ISpecificationService;
import com.pinyougou.utils.BeanMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements ISpecificationService {

	@Autowired
	private SpecificationMapper specificationMapper;

	@Autowired
	private ISpecificationOptionService specificationOptionService;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Specification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public Page findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return (Page<Specification>) specificationMapper.selectByExample(null);
	}

	/**
	 * 增加
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void add(SpecificationDTO specificationDTO) {
		Specification specification = BeanMapper.map(specificationDTO, Specification.class);
		specificationMapper.insert(specification);
		Long id = specification.getId();
		List<SpecificationOptionDTO> specificationOptions = specificationDTO.getSpecificationOptionList();
		if (CollectionUtils.isEmpty(specificationOptions)) {
			return;
		}
		List<SpecificationOption> options = new ArrayList<>();
		BeanUtils.copyProperties(specificationOptions,options);
		for (SpecificationOption option : options) {
			option.setSpecId(id);
		}
		specificationOptionService.batchInsert(options);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
		specificationMapper.updateByPrimaryKey(specification);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){
		return specificationMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			specificationMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public Page findPage(Specification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example=new Example(Specification.class);
		Example.Criteria criteria = example.createCriteria();
		if(specification!=null){
			if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andLike("specName","%"+specification.getSpecName()+"%");
			}
		}
		return (Page<Specification>)specificationMapper.selectByExample(example);
	}
	
}
