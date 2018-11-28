package com.pinyougou.backend.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.GoodsDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@FeignClient("goods-server")
public interface IGoodsFeign {


	/**
	 * 返回全部列表
	 * @return
	 */
	@ApiOperation(value="分页商品列表", notes="分页商品列表")
	@RequestMapping(value = "goods/findPage", method = RequestMethod.GET)
	BaseResponse findPage(@RequestParam("page") int page,@RequestParam("rows") int rows);

	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "goods/findAll", method = RequestMethod.GET)
	@ApiOperation(value="返回全部商品列表", notes="返回全部商品列表")
	BaseResponse findAll();

	/**
	 * 增加
	 * @param goodsDTO
	 * @return
	 */
	@RequestMapping(value = "goods/add", method = RequestMethod.POST)
	@ApiOperation(value="增加商品", notes="增加商品")
	BaseResponse add(@RequestBody GoodsDTO goodsDTO);
	
	/**
	 * 修改
	 * @param goodsDTO
	 * @return
	 */
	@RequestMapping(value = "goods/update", method = RequestMethod.POST)
	@ApiOperation(value="修改商品", notes="修改商品")
	BaseResponse update(@RequestBody GoodsDTO goodsDTO);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "goods/findOne", method = RequestMethod.GET)
	@ApiOperation(value="获取商品实体", notes="获取商品实体")
	BaseResponse findOne(@RequestParam("id")Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "goods/delete", method = RequestMethod.GET)
	@ApiOperation(value="批量删除商品", notes="批量删除商品")
	BaseResponse delete(@RequestParam("ids")Long [] ids);
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @param goods
	 * @return
	 */
	@RequestMapping(value = "goods/search", method = RequestMethod.POST)
	@ApiOperation(value="查询+分页商品", notes="查询+分页商品")
	BaseResponse search(@RequestBody GoodsDTO goods,@RequestParam("page") int page,@RequestParam("rows") int rows );
	
}
