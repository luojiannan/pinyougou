package com.pinyougou.goods.controller;

import com.github.pagehelper.Page;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.common.utils.BeanMapper;
import com.pinyougou.goods.dao.entity.TypeTemplate;
import com.pinyougou.goods.dto.TypeTemplateDTO;
import com.pinyougou.goods.service.ITypeTemplateService;
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
	public BaseResponse findAll(){
		BaseResponse response = new BaseResponse();
		try{
			List<TypeTemplate> list = typeTemplateService.findAll();
			response.setData(list);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
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
	 * @param typeTemplateDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加模板", notes="增加模板")
	public BaseResponse add(@RequestBody TypeTemplateDTO typeTemplateDTO){
		BaseResponse response = new BaseResponse();
		try {
			TypeTemplate typeTemplate = BeanMapper.map(typeTemplateDTO, TypeTemplate.class);
			typeTemplateService.add(typeTemplate);
		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param typeTemplateDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改模板", notes="修改模板")
	public BaseResponse update(@RequestBody TypeTemplateDTO typeTemplateDTO){
		BaseResponse response = new BaseResponse();
		try {
			TypeTemplate typeTemplate = BeanMapper.map(typeTemplateDTO, TypeTemplate.class);
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
			TypeTemplate template = typeTemplateService.findOne(id);
			response.setResult(template);
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
	public BaseResponse search(@RequestBody TypeTemplateDTO typeTemplateDTO, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try{
			TypeTemplate typeTemplate = BeanMapper.map(typeTemplateDTO, TypeTemplate.class);
			Page data = typeTemplateService.findPage(typeTemplate, page, rows);
			response.setTotalCount(data.getTotal());
			response.setData(data.getResult());
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

}
