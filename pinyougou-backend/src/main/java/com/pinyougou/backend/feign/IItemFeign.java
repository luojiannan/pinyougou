package com.pinyougou.backend.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.ItemDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * controller
 * @author Administrator
 *
 */
@FeignClient("goods-server")
public interface IItemFeign {

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "item/findAll", method = RequestMethod.GET)
	@ApiOperation(value="查询全部类目", notes="查询全部类目")
	BaseResponse findAll();
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "item/findPage", method = RequestMethod.GET)
	@ApiOperation(value="分页全部类目", notes="分页全部类目")
	BaseResponse  findPage(@RequestParam("page") int page,@RequestParam("rows") int rows);
	
	/**
	 * 增加
	 * @param itemDTO
	 * @return
	 */
	@RequestMapping(value = "item/add", method = RequestMethod.POST)
	@ApiOperation(value="增加类目", notes="增加类目")
	BaseResponse add(@RequestBody ItemDTO itemDTO);
	
	/**
	 * 修改
	 * @param itemDTO
	 * @return
	 */
	@RequestMapping(value = "item/update", method = RequestMethod.POST)
	@ApiOperation(value="修改类目", notes="修改类目")
	BaseResponse update(@RequestBody ItemDTO itemDTO);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "item/findOne", method = RequestMethod.GET)
	@ApiOperation(value="根据id查询类目", notes="根据id查询类目")
	BaseResponse findOne(@RequestParam("id")Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "item/delete", method = RequestMethod.GET)
	@ApiOperation(value="批量删除类目", notes="批量删除类目")
	BaseResponse delete(@RequestParam("ids")Long [] ids);
	
	/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "item/search", method = RequestMethod.POST)
	@ApiOperation(value="分页查询类目", notes="分页查询类目")
	BaseResponse search(@RequestBody ItemDTO item, @RequestParam("page") int page, @RequestParam("rows") int rows);

}
