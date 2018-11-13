package com.pinyougou.controller;

import com.github.pagehelper.Page;
import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dao.entity.Specification;
import com.pinyougou.dto.SpecificationDTO;
import com.pinyougou.service.ISpecificationService;
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
@RequestMapping("/specification")
public class SpecificationController {

	@Autowired
	private ISpecificationService specificationService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@GetMapping("/findAll")
	@ApiOperation(value="查询全部规格", notes="查询全部规格")
	public BaseResponse findAll(){
		BaseResponse response = new BaseResponse();
		try{
			List<Specification> list = specificationService.findAll();
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
	@ApiOperation(value="分页查询全部规格", notes="分页查询全部规格")
	public BaseResponse findPage(int page,int rows){
		BaseResponse response = new BaseResponse();
		try{
			Page data = specificationService.findPage(page, rows);
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
	 * @param specificationDTO
	 * @return
	 */
	@PostMapping("/add")
	@ApiOperation(value="增加规格", notes="增加规格")
	public BaseResponse add(@RequestBody SpecificationDTO specificationDTO){
		BaseResponse response = new BaseResponse();
		try{
			Specification specification = BeanMapper.map(specificationDTO, Specification.class);
			specificationService.add(specification);
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
	/**
	 * 修改
	 * @param specificationDTO
	 * @return
	 */
	@PostMapping("/update")
	@ApiOperation(value="修改规格", notes="修改规格")
	public BaseResponse update(@RequestBody SpecificationDTO specificationDTO){
		BaseResponse response = new BaseResponse();
		try{
			Specification specification = BeanMapper.map(specificationDTO, Specification.class);
			specificationService.update(specification);
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
	@ApiOperation(value="根据id查询规格", notes="根据id查询规格")
	public BaseResponse findOne(Long id){
		BaseResponse response = new BaseResponse();
		try{
			Specification specification = specificationService.findOne(id);
			response.setResult(specification);
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
	@ApiOperation(value="批量删除规格", notes="批量删除规格")
	public BaseResponse delete(Long [] ids){
		BaseResponse response = new BaseResponse();
		try{
			specificationService.delete(ids);
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
	@ApiOperation(value="按条件分页查询规格", notes="按条件分页查询规格")
	public BaseResponse search(@RequestBody SpecificationDTO specificationDTO, int page, int rows  ){
		BaseResponse response = new BaseResponse();
		try{
			Specification specification = BeanMapper.map(specificationDTO, Specification.class);
			Page<Specification> data = (Page<Specification>) specificationService.findPage(specification, page, rows);
			response.setTotalCount(data.getTotal());
			response.setData(data.getResult());
		}catch (Exception e){
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}
	
}
