package com.pinyougou.controller;

import com.github.pagehelper.Page;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dao.entity.TypeTemplate;
import com.pinyougou.service.ITypeTemplateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

	@Autowired
	private ITypeTemplateService typeTemplateService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部模板", notes="查询全部模板")
	public List<TypeTemplate> findAll(){
		return typeTemplateService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findPage")
	@ApiOperation(value="分页查询模板", notes="分页查询模板")
	public BaseResponse findPage(int page, int rows){
		BaseResponse response = new BaseResponse();
		try{
			Page data = typeTemplateService.findPage(page, rows);
			response.setTotalCount(data.getTotal());
			response.setData(data.getResult());
		}catch (Exception e){
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 增加
	 * @param typeTemplate
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加模板", notes="增加模板")
	public BaseResponse add(@RequestBody TypeTemplate typeTemplate){
		BaseResponse response = new BaseResponse();
		try {
			typeTemplateService.add(typeTemplate);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param typeTemplate
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改模板", notes="修改模板")
	public BaseResponse update(@RequestBody TypeTemplate typeTemplate){
		BaseResponse response = new BaseResponse();
		try {
			typeTemplateService.update(typeTemplate);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ApiOperation(value="根据id查询模板", notes="根据id查询模板")
	public BaseResponse findOne(Long id){
		BaseResponse response = new BaseResponse();
		try{
			typeTemplateService.findOne(id);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@GetMapping("/delete")
	@ApiOperation(value="批量删除模板", notes="批量删除模板")
	public BaseResponse delete(Long [] ids){
		BaseResponse response = new BaseResponse();
		try {
			typeTemplateService.delete(ids);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@PostMapping("/search")
	@ApiOperation(value="按条件分页查询模板", notes="按条件分页查询模板")
	public BaseResponse search(@RequestBody TypeTemplate typeTemplate, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try{
			typeTemplateService.findPage(typeTemplate, page, rows);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
}
