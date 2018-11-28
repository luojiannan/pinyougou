package com.pinyougou.backend.controller.goods;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.SpecificationOptionDTO;
import com.pinyougou.backend.feign.ISpecificationOptionFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("backend/specificationOption")
public class SpecificationOptionController {

	@Autowired
	private ISpecificationOptionFeign specificationOptionFeign;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部规格选择", notes="查询全部规格选择")
	public BaseResponse findAll(){
		return specificationOptionFeign.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页查询规格选择", notes="分页查询卖家选择")
	public BaseResponse findPage(Integer page,Integer rows){
		return specificationOptionFeign.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param specificationOptionDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加规格选择", notes="增加规格选择")
	public BaseResponse add(@RequestBody SpecificationOptionDTO specificationOptionDTO){
		return specificationOptionFeign.add(specificationOptionDTO);
	}
	
	/**
	 * 修改
	 * @param specificationOptionDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改规格选择", notes="修改规格选择")
	public BaseResponse update(@RequestBody SpecificationOptionDTO specificationOptionDTO){
		return specificationOptionFeign.update(specificationOptionDTO);
	}
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ApiOperation(value="根据id查询规格选择", notes="根据id查询规格选择")
	public BaseResponse findOne(Long id){
		return specificationOptionFeign.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除规格选择", notes="批量删除规格选择")
	public BaseResponse delete(Long [] ids){
		return specificationOptionFeign.delete(ids);
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="按条件分页查询规格选择", notes="按条件分页查询规格选择")
	public BaseResponse search(@RequestBody SpecificationOptionDTO specificationOptionDTO, int page, int rows  ){
		return specificationOptionFeign.search(specificationOptionDTO, page, rows);
	}
	
}
