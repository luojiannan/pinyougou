package com.pinyougou.controller;

import com.github.pagehelper.Page;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dao.entity.Item;
import com.pinyougou.dto.ItemDTO;
import com.pinyougou.service.IItemService;
import com.pinyougou.utils.BeanMapper;
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
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private IItemService itemService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部类目", notes="查询全部类目")
	public BaseResponse findAll(){
		BaseResponse response = new BaseResponse();
		try{
			List<Item> list = itemService.findAll();
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
	@ApiOperation(value="分页全部类目", notes="分页全部类目")
	public BaseResponse  findPage(int page,int rows){
		BaseResponse response = new BaseResponse();
		try{
			Page data = itemService.findPage(page, rows);
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
	 * @param itemDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加类目", notes="增加类目")
	public BaseResponse add(@RequestBody ItemDTO itemDTO){
		BaseResponse response = new BaseResponse();
		try{
			Item item = BeanMapper.map(itemDTO, Item.class);
			itemService.add(item);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param itemDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改类目", notes="修改类目")
	public BaseResponse update(@RequestBody ItemDTO itemDTO){
		BaseResponse response = new BaseResponse();
		try{
			Item item = BeanMapper.map(itemDTO, Item.class);
			itemService.update(item);
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
	@GetMapping("/findOne")
	@ApiOperation(value="根据id查询类目", notes="根据id查询类目")
	public BaseResponse findOne(Long id){
		BaseResponse response = new BaseResponse();
		try{
			Item item = itemService.findOne(id);
			response.setResult(item);
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
	@ApiOperation(value="批量删除类目", notes="批量删除类目")
	public BaseResponse delete(Long [] ids){
		BaseResponse response = new BaseResponse();
		try{
			itemService.delete(ids);
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
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	public BaseResponse search(@RequestBody ItemDTO itemDTO, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try{
			Item item = BeanMapper.map(itemDTO, Item.class);
			Page<Item> data = (Page<Item>) itemService.findPage(item, page, rows);
			response.setTotalCount(data.getTotal());
			response.setData(data.getResult());
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
}
