package com.pinyougou.backend.controller.goods;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.ItemCatDTO;
import com.pinyougou.backend.feign.IItemCatFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("backend/itemCat")
public class ItemCatController {

	@Autowired
	private IItemCatFeign itemCatFeign;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部类目", notes="查询全部类目")
	public BaseResponse findAll(){
		return itemCatFeign.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	public BaseResponse findPage(Integer page,Integer rows){
		if (page == null) {
			page = 1;
		}
		if (rows == null) {
			rows = 20;
		}
		return itemCatFeign.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param itemCatDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加类目", notes="增加类目")
	public BaseResponse add(@RequestBody ItemCatDTO itemCatDTO){
		return itemCatFeign.add(itemCatDTO);
	}
	
	/**
	 * 修改
	 * @param itemCatDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改类目", notes="修改类目")
	public BaseResponse update(@RequestBody ItemCatDTO itemCatDTO){
		return itemCatFeign.update(itemCatDTO);
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ApiOperation(value="根据id查询类目", notes="根据id查询类目")
	public BaseResponse findOne(Long id){
		return itemCatFeign.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除类目", notes="批量删除类目")
	public BaseResponse delete(Long [] ids){
		return itemCatFeign.delete(ids);
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	public BaseResponse search(@RequestBody ItemCatDTO itemCatDTO, Integer page, Integer rows  ){
		if (page == null) {
			page = 1;
		}
		if (rows == null) {
			rows = 20;
		}
		return itemCatFeign.search(itemCatDTO, page, rows);
	}
	
}
