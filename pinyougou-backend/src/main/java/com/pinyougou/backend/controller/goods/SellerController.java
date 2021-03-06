package com.pinyougou.backend.controller.goods;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.SellerDTO;
import com.pinyougou.backend.feign.ISellerFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("backend/seller")
public class SellerController {

	@Autowired
	private ISellerFeign sellerFeign;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部卖家", notes="查询全部卖家")
	public BaseResponse findAll(){
		return sellerFeign.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页查询卖家", notes="分页查询卖家")
	public BaseResponse  findPage(Integer page,Integer rows){
		return sellerFeign.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param sellerDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加卖家", notes="增加卖家")
	public BaseResponse add(@RequestBody SellerDTO sellerDTO){
		return sellerFeign.add(sellerDTO);
	}
	
	/**
	 * 修改
	 * @param sellerDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改卖家", notes="修改卖家")
	public BaseResponse update(@RequestBody SellerDTO sellerDTO){
		return sellerFeign.update(sellerDTO);
	}
	
	/**
	 * 获取实体
	 * @param sellerId
	 * @return
	 */
	@RequestMapping("/findOne")
	@ApiOperation(value="根据sellerId查询卖家", notes="根据sellerId查询卖家")
	public BaseResponse findOne(String sellerId){
		return sellerFeign.findOne(sellerId);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除卖家", notes="批量删除卖家")
	public BaseResponse delete(Long [] ids){
		return sellerFeign.delete(ids);
	}
	
	/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="分页查询卖家", notes="分页查询卖家")
	public BaseResponse search(@RequestBody SellerDTO sellerDTO, int page, int rows  ){
		return sellerFeign.search(sellerDTO, page, rows);
	}

	/**
	 * 修改商家审核状态
	 * @param sellerId
	 * @param status
	 * @return
	 */
	@PostMapping("/updateStatus")
	@ApiOperation(value="修改商家审核状态", notes="修改商家审核状态")
	public BaseResponse updateStatus(String sellerId, String status){
		return sellerFeign.updateStatus(sellerId, status);
	}
	
}
