package com.pinyougou.backend.feign;

import com.pinyougou.backend.dto.Specification;
import com.pinyougou.backend.dto.SpecificationDTO;
import com.pinyougou.common.dto.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@FeignClient("goods-server")
@Component
public interface ISpecificationFeign {


	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "specification/findAll", method = RequestMethod.GET)
	@ApiOperation(value="查询全部规格", notes="查询全部规格")
	BaseResponse findAll();
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "specification/findPage", method = RequestMethod.GET)
	@ApiOperation(value="分页查询全部规格", notes="分页查询全部规格")
	BaseResponse findPage(@RequestParam("page") int page,@RequestParam("rows") int rows);
	
	/**
	 * 增加
	 * @param specificationDTO
	 * @return
	 */
	@RequestMapping(value = "specification/add", method = RequestMethod.POST)
	@ApiOperation(value="增加规格", notes="增加规格")
	BaseResponse add(@RequestBody SpecificationDTO specificationDTO);
	
	/**
	 * 修改
	 * @param specificationDTO
	 * @return
	 */
	@RequestMapping(value = "specification/update", method = RequestMethod.POST)
	@ApiOperation(value="修改规格", notes="修改规格")
	BaseResponse update(@RequestBody SpecificationDTO specificationDTO);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "specification/findOne", method = RequestMethod.GET)
	@ApiOperation(value="根据id查询规格", notes="根据id查询规格")
	BaseResponse findOne(@RequestParam("id")Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "specification/delete", method = RequestMethod.GET)
	@ApiOperation(value="批量删除规格", notes="批量删除规格")
	BaseResponse delete(@RequestParam("ids")List<Long> ids);

		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "specification/search", method = RequestMethod.POST)
	@ApiOperation(value="按条件分页查询规格", notes="按条件分页查询规格")
	BaseResponse search(@RequestBody Specification specification, @RequestParam("page") int page, @RequestParam("rows") int rows);

	@RequestMapping(value = "specification/selectOptionList", method = RequestMethod.GET)
	@ApiOperation(value="查询规格列表", notes="查询规格列表")
	BaseResponse selectOptionList();
}
