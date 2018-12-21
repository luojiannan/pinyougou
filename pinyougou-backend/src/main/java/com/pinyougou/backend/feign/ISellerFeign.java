package com.pinyougou.backend.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.SellerDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
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
@Component
public interface ISellerFeign {

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "seller/findAll", method = RequestMethod.GET)
	@ApiOperation(value="查询全部卖家", notes="查询全部卖家")
	BaseResponse findAll();
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "seller/findPage", method = RequestMethod.GET)
	@ApiOperation(value="分页查询卖家", notes="分页查询卖家")
	BaseResponse  findPage(@RequestParam("page") int page,@RequestParam("rows") int rows);
	
	/**
	 * 增加
	 * @param sellerDTO
	 * @return
	 */
	@RequestMapping(value = "seller/add", method = RequestMethod.POST)
	@ApiOperation(value="增加卖家", notes="增加卖家")
	BaseResponse add(@RequestBody SellerDTO sellerDTO);
	
	/**
	 * 修改
	 * @param sellerDTO
	 * @return
	 */
	@RequestMapping(value = "seller/update", method = RequestMethod.POST)
	@ApiOperation(value="修改卖家", notes="修改卖家")
	BaseResponse update(@RequestBody SellerDTO sellerDTO);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "seller/findOne", method = RequestMethod.GET)
	@ApiOperation(value="根据id查询卖家", notes="根据id查询卖家")
	BaseResponse findOne(@RequestParam("id")Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "seller/delete", method = RequestMethod.GET)
	@ApiOperation(value="批量删除卖家", notes="批量删除卖家")
	BaseResponse delete(@RequestParam("ids")Long [] ids);
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "seller/search", method = RequestMethod.POST)
	@ApiOperation(value="分页查询卖家", notes="分页查询卖家")
	BaseResponse search(@RequestBody SellerDTO seller, @RequestParam("page") int page, @RequestParam("rows") int rows);
	
}
