package com.pinyougou.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.dto.SpecificationOptionDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * controller
 * @author Administrator
 *
 */
@FeignClient("goods")
public interface ISpecificationOptionFeign {

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "specificationOption/findAll", method = RequestMethod.GET)
	@ApiOperation(value="查询全部规格选择", notes="查询全部规格选择")
	BaseResponse findAll();
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "specificationOption/findPage", method = RequestMethod.GET)
	@ApiOperation(value="分页查询规格选择", notes="分页查询卖家选择")
	BaseResponse findPage(@RequestParam("page") int page,@RequestParam("rows") int rows);
	
	/**
	 * 增加
	 * @param specificationOptionDTO
	 * @return
	 */
	@RequestMapping(value = "specificationOption/add", method = RequestMethod.GET)
	@ApiOperation(value="增加规格选择", notes="增加规格选择")
	BaseResponse add(@RequestBody SpecificationOptionDTO specificationOptionDTO);
	
	/**
	 * 修改
	 * @param specificationOptionDTO
	 * @return
	 */
	@RequestMapping(value = "specificationOption/update", method = RequestMethod.POST)
	@ApiOperation(value="修改规格选择", notes="修改规格选择")
	BaseResponse update(@RequestBody SpecificationOptionDTO specificationOptionDTO);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "specificationOption/findOne", method = RequestMethod.GET)
	@ApiOperation(value="根据id查询规格选择", notes="根据id查询规格选择")
	BaseResponse findOne(@RequestParam("id")Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "specificationOption/delete", method = RequestMethod.GET)
	@ApiOperation(value="批量删除规格选择", notes="批量删除规格选择")
	BaseResponse delete(@RequestParam("ids")Long [] ids);
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "specificationOption/search", method = RequestMethod.POST)
	@ApiOperation(value="按条件分页查询规格选择", notes="按条件分页查询规格选择")
	BaseResponse search(@RequestBody SpecificationOptionDTO specificationOption,@RequestParam("page") int page,@RequestParam("rows") int rows);
	
}
