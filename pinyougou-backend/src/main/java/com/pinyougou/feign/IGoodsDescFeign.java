package com.pinyougou.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dto.GoodsDescDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@FeignClient("goods-server")
public interface IGoodsDescFeign {


	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "goodsDesc/findAll", method = RequestMethod.GET)
	@ApiOperation(value="全部商品描述", notes="全部商品描述")
	BaseResponse findAll();
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@RequestMapping(value = "goodsDesc/findPage", method = RequestMethod.GET)
	@ApiOperation(value="分页商品描述", notes="分页商品描述")
	BaseResponse findPage(int page,int rows);
	
	/**
	 * 增加
	 * @param goodsDescDTO
	 * @return
	 */
	@RequestMapping(value = "goodsDesc/add", method = RequestMethod.POST)
	@ApiOperation(value="增加商品描述", notes="增加商品描述")
	BaseResponse add(@RequestBody GoodsDescDTO goodsDescDTO);
	
	/**
	 * 修改
	 * @param goodsDescDTO
	 * @return
	 */
	@RequestMapping(value = "goodsDesc/update", method = RequestMethod.POST)
	@ApiOperation(value="修改商品描述", notes="修改商品描述")
	BaseResponse update(@RequestBody GoodsDescDTO goodsDescDTO);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "goodsDesc/findOne", method = RequestMethod.GET)
	@ApiOperation(value="根据id查询商品描述", notes="根据id查询商品描述")
	BaseResponse findOne(Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "goodsDesc/delete", method = RequestMethod.GET)
	@ApiOperation(value="批量删除商品描述", notes="批量删除商品描述")
	BaseResponse delete(Long [] ids);
	
	/**
	 * 查询+分页
	 * @param page
	 * @param goodsDesc
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "goodsDesc/search", method = RequestMethod.POST)
	@ApiOperation(value="分页查询商品描述", notes="分页查询商品描述")
	BaseResponse search(@RequestBody GoodsDescDTO goodsDesc, int page, int rows  );
	
}
