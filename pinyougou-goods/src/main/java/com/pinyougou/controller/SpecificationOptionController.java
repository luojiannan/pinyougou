package com.pinyougou.controller;

import com.github.pagehelper.Page;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dao.entity.SpecificationOption;
import com.pinyougou.dto.SpecificationOptionDTO;
import com.pinyougou.service.ISpecificationOptionService;
import com.pinyougou.utils.BeanMapper;
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
@RequestMapping("/specificationOption")
public class SpecificationOptionController {

	@Autowired
	private ISpecificationOptionService specificationOptionService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部规格选择", notes="查询全部规格选择")
	public BaseResponse findAll(){
		BaseResponse response = new BaseResponse();
		try{
			List<SpecificationOption> list = specificationOptionService.findAll();
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
	@ApiOperation(value="分页查询规格选择", notes="分页查询卖家选择")
	public BaseResponse findPage(int page,int rows){
		BaseResponse response = new BaseResponse();
		try{
			Page data = specificationOptionService.findPage(page, rows);
			response.setData(data.getResult());
			response.setTotalCount(data.getTotal());
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 增加
	 * @param specificationOptionDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加规格选择", notes="增加规格选择")
	public BaseResponse add(@RequestBody SpecificationOptionDTO specificationOptionDTO){
		BaseResponse response = new BaseResponse();
		try{
			SpecificationOption specificationOption = BeanMapper.map(specificationOptionDTO, SpecificationOption.class);
			specificationOptionService.add(specificationOption);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param specificationOptionDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改规格选择", notes="修改规格选择")
	public BaseResponse update(@RequestBody SpecificationOptionDTO specificationOptionDTO){
		BaseResponse response = new BaseResponse();
		try{
			SpecificationOption specificationOption = BeanMapper.map(specificationOptionDTO, SpecificationOption.class);
			specificationOptionService.update(specificationOption);
		}catch (Exception e){
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
	@ApiOperation(value="根据id查询规格选择", notes="根据id查询规格选择")
	public BaseResponse findOne(Long id){
		BaseResponse response = new BaseResponse();
		try{
			SpecificationOption specificationOption = specificationOptionService.findOne(id);
			response.setResult(specificationOption);
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
	@ApiOperation(value="批量删除规格选择", notes="批量删除规格选择")
	public BaseResponse delete(Long [] ids){
		BaseResponse response = new BaseResponse();
		try{
			specificationOptionService.delete(ids);
		}catch (Exception e){
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
	@ApiOperation(value="按条件分页查询规格选择", notes="按条件分页查询规格选择")
	public BaseResponse search(@RequestBody SpecificationOption specificationOption, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try{
			Page<SpecificationOption> data = (Page<SpecificationOption>) specificationOptionService.findPage(specificationOption, page, rows);
			response.setTotalCount(data.getTotal());
			response.setData(data.getResult());
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
}
