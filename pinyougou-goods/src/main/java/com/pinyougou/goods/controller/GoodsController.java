package com.pinyougou.goods.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.common.utils.BeanMapper;
import com.pinyougou.common.utils.ParamUtils;
import com.pinyougou.goods.dao.entity.Goods;
import com.pinyougou.goods.dto.GoodsDTO;
import com.pinyougou.goods.service.IGoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private IGoodsService goodsService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="返回全部商品列表", notes="返回全部商品列表")
	public BaseResponse findAll(){
		BaseResponse response = new BaseResponse();
		try {
			List<Goods> goodsList = goodsService.findAll();
			response.setResult(goodsList);
		}catch (RuntimeException e) {
			response.setErrorMessage(e.getMessage());
		}catch (Exception e){
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页商品列表", notes="分页商品列表")
	public BaseResponse findPage(int page, int rows){
		BaseResponse response = new BaseResponse();
		try{
			Page pageData = goodsService.findPage(page, rows);
			response.setTotalCount(pageData.getTotal());
			response.setData(pageData.getResult());
		}catch (RuntimeException e) {
			response.setErrorMessage(e.getMessage());
		}catch (Exception e) {
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 增加
	 * @param goodsDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加商品", notes="增加商品")
	public BaseResponse add(@RequestBody GoodsDTO goodsDTO){
		BaseResponse response = new BaseResponse();
		try {
			Goods goods = BeanMapper.map(goodsDTO, Goods.class);
			goodsService.add(goods);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param goodsDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改商品", notes="修改商品")
	public BaseResponse update(@RequestBody GoodsDTO goodsDTO){
		BaseResponse response = new BaseResponse();
		try {
			Goods goods = BeanMapper.map(goodsDTO, Goods.class);
			goodsService.update(goods);
		} catch (Exception e) {
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
	@GetMapping("/findOne")
	@ApiOperation(value="获取商品实体", notes="获取商品实体")
	public BaseResponse findOne(Long id){
		BaseResponse response = new BaseResponse();
		try{
			Goods goods = goodsService.findOne(id);
			response.setResult(goods);
		}catch (Exception e) {
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
	@ApiOperation(value="批量删除商品", notes="批量删除商品")
	public BaseResponse delete(Long [] ids){
		BaseResponse response = new BaseResponse();
		try {
			goodsService.delete(ids);
		} catch (Exception e) {
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
	@ApiOperation(value="查询+分页商品", notes="查询+分页商品")
	public BaseResponse search(@RequestBody GoodsDTO goods, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try{
			PageHelper.startPage(page,rows);
			Map<String,Object> params = new HashMap<String,Object>();
			if (goods != null) {
				params = ParamUtils.convertMap(goods);
			}
			Page<Goods> data = (Page<Goods>) goodsService.findPage(params, "id", false);
			response.setData(data.getResult());
			response.setTotalCount(data.getTotal());
		}catch (Exception e){
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
}
