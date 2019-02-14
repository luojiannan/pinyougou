package com.pinyougou.backend.controller.goods;

import com.pinyougou.backend.dto.GoodsDTO;
import com.pinyougou.backend.feign.IGoodsFeign;
import com.pinyougou.common.dto.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("backend/goods")
public class GoodsController {

	@Autowired
	private IGoodsFeign goodsFeign;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="返回全部商品列表", notes="返回全部商品列表")
	public BaseResponse findAll(){
		return goodsFeign.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页商品列表", notes="分页商品列表")
	public BaseResponse findPage(Integer page, Integer rows){
		if (page == null) {
			page = 1;
		}
		if (rows == null) {
			rows = 20;
		}
		return goodsFeign.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param goodsDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加商品", notes="增加商品")
	public BaseResponse add(@RequestBody GoodsDTO goodsDTO){
		goodsDTO.getGoods().setSellerId("yijia");
		return goodsFeign.add(goodsDTO);
	}
	
	/**
	 * 修改
	 * @param goodsDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改商品", notes="修改商品")
	public BaseResponse update(@RequestBody GoodsDTO goodsDTO){
		return goodsFeign.update(goodsDTO);
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ApiOperation(value="获取商品实体", notes="获取商品实体")
	public BaseResponse findOne(Long id){
		return goodsFeign.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除商品", notes="批量删除商品")
	public BaseResponse delete(Long [] ids){
		return goodsFeign.delete(ids);
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="查询+分页商品", notes="查询+分页商品")
	public BaseResponse search(@RequestBody GoodsDTO goods, Integer page, Integer rows  ){
		if (page == null) {
			page = 1;
		}
		if (rows == null) {
			rows = 20;
		}
		return goodsFeign.search(goods, page, rows);
	}
	
}
