package com.pinyougou.goods.controller;

import com.github.pagehelper.Page;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.goods.dao.entity.GoodsDesc;
import com.pinyougou.goods.dto.GoodsDescDTO;
import com.pinyougou.goods.service.IGoodsDescService;
import com.pinyougou.goods.utils.BeanMapper;
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
@RequestMapping("/goodsDesc")
public class GoodsDescController {

	@Autowired
	private IGoodsDescService goodsDescService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="全部商品描述", notes="全部商品描述")
	public BaseResponse findAll(){
		BaseResponse response = new BaseResponse();
		try{
			List<GoodsDesc> list = goodsDescService.findAll();
			response.setData(list);
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
	@ApiOperation(value="分页商品描述", notes="分页商品描述")
	public BaseResponse findPage(int page,int rows){
		BaseResponse response = new BaseResponse();
		try{
			Page data = goodsDescService.findPage(page, rows);
			response.setTotalCount(data.getTotal());
			response.setData(data.getResult());
		}catch (Exception e) {
			response.setErrorMessage(e.getMessage());

		}
		return response;
	}
	
	/**
	 * 增加
	 * @param goodsDescDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加商品描述", notes="增加商品描述")
	public BaseResponse add(@RequestBody GoodsDescDTO goodsDescDTO){
		BaseResponse response = new BaseResponse();
		try {
			GoodsDesc goodsDesc = BeanMapper.map(goodsDescDTO, GoodsDesc.class);
			goodsDescService.add(goodsDesc);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param goodsDescDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改商品描述", notes="修改商品描述")
	public BaseResponse update(@RequestBody GoodsDescDTO goodsDescDTO){
		BaseResponse response = new BaseResponse();
		try {
			GoodsDesc goodsDesc = BeanMapper.map(goodsDescDTO, GoodsDesc.class);
			goodsDescService.update(goodsDesc);
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
	@ApiOperation(value="根据id查询商品描述", notes="根据id查询商品描述")
	public BaseResponse findOne(Long id){
		BaseResponse response = new BaseResponse();
		try{
			goodsDescService.findOne(id);
		}catch (Exception e) {
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
	@ApiOperation(value="批量删除商品描述", notes="批量删除商品描述")
	public BaseResponse delete(Long [] ids){
		BaseResponse response = new BaseResponse();
		try {
			goodsDescService.delete(ids);
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
	@ApiOperation(value="分页查询商品描述", notes="分页查询商品描述")
	public BaseResponse search(@RequestBody GoodsDescDTO goodsDescDTO, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try{
			GoodsDesc goodsDesc = BeanMapper.map(goodsDescDTO, GoodsDesc.class);
			Page data = goodsDescService.findPage(goodsDesc, page, rows);
			response.setTotalCount(data.getTotal());
			response.setResult(data.getResult());
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
}
