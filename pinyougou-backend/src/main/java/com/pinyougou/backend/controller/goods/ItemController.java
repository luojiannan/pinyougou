package com.pinyougou.backend.controller.goods;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.ItemDTO;
import com.pinyougou.backend.feign.IItemFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("backend/item")
public class ItemController {

	@Autowired
	private IItemFeign iItemFeign;
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部类目", notes="查询全部类目")
	public BaseResponse findAll(){
		return iItemFeign.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页全部类目", notes="分页全部类目")
	public BaseResponse  findPage(Integer page,Integer rows){
		return iItemFeign.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param itemDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加类目", notes="增加类目")
	public BaseResponse add(@RequestBody ItemDTO itemDTO){
		return iItemFeign.add(itemDTO);
	}
	
	/**
	 * 修改
	 * @param itemDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改类目", notes="修改类目")
	public BaseResponse update(@RequestBody ItemDTO itemDTO){
		return iItemFeign.update(itemDTO);
	}
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ApiOperation(value="根据id查询类目", notes="根据id查询类目")
	public BaseResponse findOne(Long id){
		return iItemFeign.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除类目", notes="批量删除类目")
	public BaseResponse delete(Long [] ids){
		return iItemFeign.delete(ids);
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	public BaseResponse search(@RequestBody ItemDTO itemDTO, Integer page, Integer rows  ){
		if (page == null) {
			page = 1;
		}
		if (rows == null) {
			rows = 20;
		}
		return iItemFeign.search(itemDTO, page, rows);
	}
	
}
