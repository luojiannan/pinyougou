package com.pinyougou.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.goods.dao.entity.Seller;
import com.pinyougou.goods.dao.mapper.SellerMapper;
import com.pinyougou.goods.service.ISellerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SellerServiceImpl implements ISellerService {

	@Autowired
	private SellerMapper sellerMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Seller> findAll() {
		return sellerMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public Page findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return  (Page<Seller>) sellerMapper.selectByExample(null);
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Seller seller) {
		sellerMapper.insert(seller);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Seller seller){
		sellerMapper.updateByPrimaryKey(seller);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param sellerId
	 * @return
	 */
	@Override
	public Seller findOne(String sellerId){
		return sellerMapper.selectByPrimaryKey(sellerId);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			sellerMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
	@Override
	public Page findPage(Seller seller, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(Seller.class);
		Example.Criteria criteria = example.createCriteria();
		if(seller!=null){
			if(seller.getSellerId()!=null && seller.getSellerId().length()>0){
				criteria.andLike("sellerId","%"+seller.getSellerId()+"%");
			}
			if(StringUtils.isNotBlank(seller.getName())){
				criteria.andLike("name","%"+seller.getName()+"%");
			}
			if(seller.getNickName()!=null && seller.getNickName().length()>0){
				criteria.andLike("nickName","%"+seller.getNickName()+"%");
			}
			if(seller.getPassword()!=null && seller.getPassword().length()>0){
				criteria.andLike("password","%"+seller.getPassword()+"%");
			}
			if(seller.getEmail()!=null && seller.getEmail().length()>0){
				criteria.andLike("email","%"+seller.getEmail()+"%");
			}
			if(seller.getMobile()!=null && seller.getMobile().length()>0){
				criteria.andLike("mobile","%"+seller.getMobile()+"%");
			}
			if(seller.getTelephone()!=null && seller.getTelephone().length()>0){
				criteria.andLike("telephone","%"+seller.getTelephone()+"%");
			}
			if(seller.getStatus()!=null && seller.getStatus().length()>0){
				criteria.andLike("status","%"+seller.getStatus()+"%");
			}
			if(seller.getAddressDetail()!=null && seller.getAddressDetail().length()>0){
				criteria.andLike("addressDetail","%"+seller.getAddressDetail()+"%");
			}
			if(seller.getLinkmanName()!=null && seller.getLinkmanName().length()>0){
				criteria.andLike("linkman","%"+seller.getLinkmanName()+"%");
			}
			if(seller.getLinkmanQq()!=null && seller.getLinkmanQq().length()>0){
				criteria.andLike("linkmanQq","%"+seller.getLinkmanQq()+"%");
			}
			if(seller.getLinkmanMobile()!=null && seller.getLinkmanMobile().length()>0){
				criteria.andLike("linkmanMobile","%"+seller.getLinkmanMobile()+"%");
			}
			if(seller.getLinkmanEmail()!=null && seller.getLinkmanEmail().length()>0){
				criteria.andLike("linkmanEmail","%"+seller.getLinkmanEmail()+"%");
			}
			if(seller.getLicenseNumber()!=null && seller.getLicenseNumber().length()>0){
				criteria.andLike("licenseNumber","%"+seller.getLicenseNumber()+"%");
			}
			if(seller.getTaxNumber()!=null && seller.getTaxNumber().length()>0){
				criteria.andLike("taxNumber","%"+seller.getTaxNumber()+"%");
			}
			if(seller.getOrgNumber()!=null && seller.getOrgNumber().length()>0){
				criteria.andLike("orgNumber","%"+seller.getOrgNumber()+"%");
			}
			if(seller.getLogoPic()!=null && seller.getLogoPic().length()>0){
				criteria.andLike("logoPic","%"+seller.getLogoPic()+"%");
			}
			if(seller.getBrief()!=null && seller.getBrief().length()>0){
				criteria.andLike("brief","%"+seller.getBrief()+"%");
			}
			if(seller.getLegalPerson()!=null && seller.getLegalPerson().length()>0){
				criteria.andLike("legalPerson","%"+seller.getLegalPerson()+"%");
			}
			if(seller.getLegalPersonCardId()!=null && seller.getLegalPersonCardId().length()>0){
				criteria.andLike("legalPersonCardId","%"+seller.getLegalPersonCardId()+"%");
			}
			if(seller.getBankUser()!=null && seller.getBankUser().length()>0){
				criteria.andLike("bankUser","%"+seller.getBankUser()+"%");
			}
			if(seller.getBankName()!=null && seller.getBankName().length()>0){
				criteria.andLike("bankName","%"+seller.getBankName()+"%");
			}
		}
		return (Page<Seller>)sellerMapper.selectByExample(example);
	}
	
}
