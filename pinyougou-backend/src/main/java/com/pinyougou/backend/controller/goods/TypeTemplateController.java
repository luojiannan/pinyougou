package com.pinyougou.backend.controller.goods;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.TypeTemplateDTO;
import com.pinyougou.backend.feign.ITypeTemplateFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("backend/typeTemplate")
public class TypeTemplateController {

	@Autowired
	private ITypeTemplateFeign typeTemplateFeign;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部模板", notes="查询全部模板")
	public BaseResponse findAll(){
		return typeTemplateFeign.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页查询模板", notes="分页查询模板")
	public BaseResponse findPage(Integer page,Integer rows){
		return typeTemplateFeign.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param typeTemplateDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加模板", notes="增加模板")
	public BaseResponse add(@RequestBody TypeTemplateDTO typeTemplateDTO){
		return typeTemplateFeign.add(typeTemplateDTO);
	}
	
	/**
	 * 修改
	 * @param typeTemplateDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改模板", notes="修改模板")
	public BaseResponse update(@RequestBody TypeTemplateDTO typeTemplateDTO){
		return typeTemplateFeign.update(typeTemplateDTO);
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ApiOperation(value="根据id查询模板", notes="根据id查询模板")
	public BaseResponse findOne(Long id){
		return typeTemplateFeign.findOne(id);
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除模板", notes="批量删除模板")
	public BaseResponse delete(Long [] ids){
		return typeTemplateFeign.delete(ids);
	}
	
	/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="按条件分页查询模板", notes="按条件分页查询模板")
	public BaseResponse search(@RequestBody TypeTemplateDTO typeTemplateDTO, int page, int rows  ){
		return typeTemplateFeign.search(typeTemplateDTO, page, rows);
	}

}
