package com.pinyougou.backend.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.ItemCatDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@FeignClient("goods-server")
@Component
public interface IItemCatFeign {

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "itemCat/findAll", method = RequestMethod.GET)
	@ApiOperation(value="查询全部类目", notes="查询全部类目")
	BaseResponse findAll();
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "itemCat/findPage", method = RequestMethod.GET)
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	BaseResponse  findPage(@RequestParam("page") int page,@RequestParam("rows") int rows);
	
	/**
	 * 增加
	 * @param itemCatDTO
	 * @return
	 */
	@RequestMapping(value = "itemCat/add", method = RequestMethod.POST)
	@ApiOperation(value="增加类目", notes="增加类目")
	BaseResponse add(@RequestBody ItemCatDTO itemCatDTO);
	
	/**
	 * 修改
	 * @param itemCatDTO
	 * @return
	 */
	@RequestMapping(value = "itemCat/update", method = RequestMethod.POST)
	@ApiOperation(value="修改类目", notes="修改类目")
	BaseResponse update(@RequestBody ItemCatDTO itemCatDTO);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "itemCat/findOne", method = RequestMethod.GET)
	@ApiOperation(value="根据id查询类目", notes="根据id查询类目")
	BaseResponse findOne(@RequestParam("id")Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "itemCat/delete", method = RequestMethod.GET)
	@ApiOperation(value="批量删除类目", notes="批量删除类目")
	BaseResponse delete(@RequestParam("ids")Long [] ids);
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "itemCat/search", method = RequestMethod.POST)
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	BaseResponse search(@RequestBody ItemCatDTO itemCat, @RequestParam("page") int page,@RequestParam("rows") int rows);

	@RequestMapping(value = "itemCat/findByParentId", method = RequestMethod.GET)
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	BaseResponse findByParentId(@RequestParam("parentId")Long parentId);
	
}
