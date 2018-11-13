package com.pinyougou.controller.goods;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dto.GoodsDescDTO;
import com.pinyougou.feign.IGoodsDescFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("backend/goodsDesc")
public class GoodsDescController {

	@Autowired
	private IGoodsDescFeign goodsDescFeign;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="全部商品描述", notes="全部商品描述")
	public BaseResponse findAll(){
		return goodsDescFeign.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页商品描述", notes="分页商品描述")
	public BaseResponse findPage(Integer page,Integer rows){
		if (page == null) {
			page = 1;
		}
		if (rows == null) {
			rows = 20;
		}
		return goodsDescFeign.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param goodsDescDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加商品描述", notes="增加商品描述")
	public BaseResponse add(@RequestBody GoodsDescDTO goodsDescDTO){
		return goodsDescFeign.add(goodsDescDTO);
	}
	
	/**
	 * 修改
	 * @param goodsDescDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改商品描述", notes="修改商品描述")
	public BaseResponse update(@RequestBody GoodsDescDTO goodsDescDTO){
		return goodsDescFeign.update(goodsDescDTO);
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ApiOperation(value="根据id查询商品描述", notes="根据id查询商品描述")
	public BaseResponse findOne(Long id){
		return goodsDescFeign.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除商品描述", notes="批量删除商品描述")
	public BaseResponse delete(Long [] ids){
		return goodsDescFeign.delete(ids);
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="分页查询商品描述", notes="分页查询商品描述")
	public BaseResponse search(@RequestBody GoodsDescDTO goodsDescDTO, Integer page, Integer rows  ){
		if (page == null) {
			page = 1;
		}
		if (rows == null) {
			rows = 20;
		}
		return goodsDescFeign.search(goodsDescDTO, page, rows);
	}
	
}
