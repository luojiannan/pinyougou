package com.pinyougou.controller.goods;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dto.SpecificationDTO;
import com.pinyougou.feign.ISpecificationFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("backend/specification")
public class SpecificationController {

	@Autowired
	private ISpecificationFeign specificationFeign;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部规格", notes="查询全部规格")
	public BaseResponse findAll(){
		return specificationFeign.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页查询全部规格", notes="分页查询全部规格")
	public BaseResponse findPage(Integer page,Integer rows){
		return specificationFeign.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param specificationDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加规格", notes="增加规格")
	public BaseResponse add(@RequestBody SpecificationDTO specificationDTO){
		return specificationFeign.add(specificationDTO);
	}
	
	/**
	 * 修改
	 * @param specificationDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改规格", notes="修改规格")
	public BaseResponse update(@RequestBody SpecificationDTO specificationDTO){
		return specificationFeign.update(specificationDTO);
	}
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ApiOperation(value="根据id查询规格", notes="根据id查询规格")
	public BaseResponse findOne(Long id){
		return specificationFeign.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除规格", notes="批量删除规格")
	public BaseResponse delete(Long [] ids){
		return specificationFeign.delete(ids);
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="按条件分页查询规格", notes="按条件分页查询规格")
	public BaseResponse search(@RequestBody SpecificationDTO specificationDTO, Integer page, Integer rows  ){
		return specificationFeign.search(specificationDTO, page, rows);
	}
	
}
