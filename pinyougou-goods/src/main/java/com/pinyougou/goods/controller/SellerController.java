package com.pinyougou.goods.controller;

import com.github.pagehelper.Page;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.common.utils.BeanMapper;
import com.pinyougou.goods.dao.entity.Seller;
import com.pinyougou.goods.dto.SellerDTO;
import com.pinyougou.goods.service.ISellerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

	@Autowired
	private ISellerService sellerService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部卖家", notes="查询全部卖家")
	public BaseResponse findAll(){
		BaseResponse response = new BaseResponse();
		try{
			List<Seller> list = sellerService.findAll();
			response.setData(list);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页查询卖家", notes="分页查询卖家")
	public BaseResponse  findPage(int page,int rows){
		BaseResponse response = new BaseResponse();
		try{
			Page data = sellerService.findPage(page, rows);
			response.setData(data.getResult());
			response.setTotalCount(data.getTotal());
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 增加
	 * @param sellerDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加卖家", notes="增加卖家")
	public BaseResponse add(@RequestBody SellerDTO sellerDTO){
		BaseResponse response = new BaseResponse();
		try{
			Seller seller = BeanMapper.map(sellerDTO, Seller.class);
			sellerService.add(seller);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param sellerDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改卖家", notes="修改卖家")
	public BaseResponse update(@RequestBody SellerDTO sellerDTO){
		BaseResponse response = new BaseResponse();
		try{
			Seller seller = BeanMapper.map(sellerDTO, Seller.class);
			sellerService.update(seller);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	@ApiOperation(value="根据id查询卖家", notes="根据id查询卖家")
	public BaseResponse findOne(Long id){
		BaseResponse response = new BaseResponse();
		try{
			Seller seller = sellerService.findOne(id);
			response.setResult(seller);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除卖家", notes="批量删除卖家")
	public BaseResponse delete(Long [] ids){
		BaseResponse response = new BaseResponse();
		try{
			sellerService.delete(ids);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="分页查询卖家", notes="分页查询卖家")
	public BaseResponse search(@RequestBody SellerDTO sellerDTO, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try{
			Seller seller = BeanMapper.map(sellerDTO, Seller.class);
			Page<Seller> data = (Page<Seller>) sellerService.findPage(seller, page, rows);
			response.setTotalCount(data.getTotal());
			response.setData(data.getResult());
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
}
