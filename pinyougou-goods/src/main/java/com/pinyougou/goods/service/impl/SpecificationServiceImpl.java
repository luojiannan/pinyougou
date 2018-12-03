package com.pinyougou.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.goods.dao.entity.Specification;
import com.pinyougou.goods.dao.entity.SpecificationOption;
import com.pinyougou.goods.dao.mapper.SpecificationMapper;
import com.pinyougou.goods.dao.mapper.SpecificationOptionMapper;
import com.pinyougou.goods.dto.SpecificationDTO;
import com.pinyougou.goods.dto.SpecificationOptionDTO;
import com.pinyougou.goods.service.ISpecificationOptionService;
import com.pinyougou.goods.service.ISpecificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	@Autowired
	private SpecificationOptionMapper specificationOptionMapper;
	
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
		Specification specification = specificationDTO.getSpecification();
		specificationMapper.insert(specification);
		Long id = specification.getId();
		List<SpecificationOptionDTO> specificationOptions = specificationDTO.getSpecificationOptionList();
		if (CollectionUtils.isEmpty(specificationOptions)) {
			return;
		}
		this.addSpecificationOptions(specificationOptions, id);
	}

	
	/**
	 * 修改
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(SpecificationDTO dto){
		if (dto == null || dto.getSpecification() == null) {
			throw new RuntimeException("参数错误");
		}
		Specification specification = dto.getSpecification();
		if (specification.getId() == null) {
			return ;
		}
		specificationMapper.updateByPrimaryKey(specification);
		Example example = new Example(SpecificationOption.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("specId", specification.getId());
		specificationOptionMapper.deleteByExample(example);
		List<SpecificationOptionDTO> optionList = dto.getSpecificationOptionList();
		if (CollectionUtils.isEmpty(optionList)) {
			return;
		}
		this.addSpecificationOptions(optionList, specification.getId());

	}

	private void addSpecificationOptions(List<SpecificationOptionDTO> optionList, Long id) {
		List<SpecificationOption> options = new ArrayList<>();
		for (SpecificationOptionDTO optionDTO : optionList) {
			SpecificationOption option = new SpecificationOption();
			BeanUtils.copyProperties(optionDTO, option);
			option.setSpecId(id);
			options.add(option);
		}
		specificationOptionService.batchInsert(options);
	}

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public SpecificationDTO findOne(Long id){
		SpecificationDTO dto = new SpecificationDTO();
		Specification specification = specificationMapper.selectByPrimaryKey(id);
		dto.setSpecification(specification);
		Example example=new Example(SpecificationOption.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andEqualTo("specId", id);
		List<SpecificationOption> options = specificationOptionMapper.selectByExample(example);
		List<SpecificationOptionDTO> list = new ArrayList<>();
		if (!CollectionUtils.isEmpty(options)) {
			for (SpecificationOption option : options) {
				SpecificationOptionDTO optionDTO = new SpecificationOptionDTO();
				BeanUtils.copyProperties(option, optionDTO);
				list.add(optionDTO);
			}
		}
		dto.setSpecificationOptionList(list);
		return dto;
	}

	/**
	 * 批量删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(List<Long> ids) {
		specificationMapper.batchDelete(ids);
		specificationOptionMapper.batchDeleteBySpecId(ids);
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

	@Override
	public List<Map> selectOptionList() {
		return specificationMapper.selectOptionList();
	}
}
