package com.pinyougou.goods.controller;

import com.github.pagehelper.Page;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.common.utils.BeanMapper;
import com.pinyougou.goods.dao.entity.ItemCat;
import com.pinyougou.goods.dto.ItemCatDTO;
import com.pinyougou.goods.service.IItemCatService;
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
@RequestMapping("/itemCat")
public class ItemCatController {

	@Autowired
	private IItemCatService itemCatService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部类目", notes="查询全部类目")
	public BaseResponse findAll(){
		BaseResponse response = new BaseResponse();
		try{
			List<ItemCat> list = itemCatService.findAll();
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
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	public BaseResponse  findPage(int page,int rows){
		BaseResponse response = new BaseResponse();
		try{
			List<ItemCat> list = itemCatService.findPage(page, rows);
			response.setData(list);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 增加
	 * @param itemCatDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加类目", notes="增加类目")
	public BaseResponse add(@RequestBody ItemCatDTO itemCatDTO){
		BaseResponse response = new BaseResponse();
		try {
			ItemCat itemCat = BeanMapper.map(itemCatDTO, ItemCat.class);
			itemCatService.add(itemCat);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param itemCatDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改类目", notes="修改类目")
	public BaseResponse update(@RequestBody ItemCatDTO itemCatDTO){
		BaseResponse response = new BaseResponse();
		try {
			ItemCat itemCat = BeanMapper.map(itemCatDTO, ItemCat.class);
			itemCatService.update(itemCat);
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
	@ApiOperation(value="根据id查询类目", notes="根据id查询类目")
	public BaseResponse findOne(Long id){
		BaseResponse response = new BaseResponse();
		try {
			ItemCat item = itemCatService.findOne(id);
			response.setResult(item);
		} catch (Exception e) {
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
	@ApiOperation(value="批量删除类目", notes="批量删除类目")
	public BaseResponse delete(Long [] ids){
		BaseResponse response = new BaseResponse();
		try {
			itemCatService.delete(ids);
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
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	public BaseResponse search(@RequestBody ItemCatDTO itemCatDTO, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try {
			ItemCat itemCat = BeanMapper.map(itemCatDTO, ItemCat.class);
			Page data = itemCatService.findPage(itemCat, page, rows);
			response.setData(data.getResult());
			response.setTotalCount(data.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	@GetMapping("/findByParentId")
	@ApiOperation(value="根据上级id查询商品分类列表", notes="根据上级id查询商品分类列表")
	public BaseResponse findByParentId(Long parentId){
		BaseResponse response = new BaseResponse();
		try{
			List<ItemCat> list = itemCatService.findByParentId(parentId);
			response.setData(list);
		}catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}


	
}
