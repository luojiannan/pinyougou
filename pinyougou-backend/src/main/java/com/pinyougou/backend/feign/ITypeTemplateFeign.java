package com.pinyougou.backend.feign;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.backend.dto.TypeTemplateDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * controller
 * @author Administrator
 *
 */
@FeignClient("goods-server")
public interface ITypeTemplateFeign {

	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "typeTemplate/findAll", method = RequestMethod.GET)
	@ApiOperation(value="查询全部模板", notes="查询全部模板")
	public BaseResponse findAll();
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping(value = "typeTemplate/findPage", method = RequestMethod.GET)
	@ApiOperation(value="分页查询模板", notes="分页查询模板")
	public BaseResponse findPage(@RequestParam("page") int page,@RequestParam("rows") int rows);
	
	/**
	 * 增加
	 * @param typeTemplateDTO
	 * @return
	 */
	@RequestMapping(value = "typeTemplate/add", method = RequestMethod.POST)
	@ApiOperation(value="增加模板", notes="增加模板")
	public BaseResponse add(@RequestBody TypeTemplateDTO typeTemplateDTO);
	
	/**
	 * 修改
	 * @param typeTemplateDTO
	 * @return
	 */
	@RequestMapping(value = "typeTemplate/update", method = RequestMethod.POST)
	@ApiOperation(value="修改模板", notes="修改模板")
	public BaseResponse update(@RequestBody TypeTemplateDTO typeTemplateDTO);
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "typeTemplate/findOne", method = RequestMethod.GET)
	@ApiOperation(value="根据id查询模板", notes="根据id查询模板")
	public BaseResponse findOne(@RequestParam("id")Long id);
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "typeTemplate/delete", method = RequestMethod.GET)
	@ApiOperation(value="批量删除模板", notes="批量删除模板")
	public BaseResponse delete(@RequestParam("ids")Long [] ids);
	
		/**
	 * 查询+分页
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "typeTemplate/search", method = RequestMethod.POST)
	@ApiOperation(value="按条件分页查询模板", notes="按条件分页查询模板")
	public BaseResponse search(@RequestBody TypeTemplateDTO typeTemplate, @RequestParam("page") int page, @RequestParam("rows") int rows);
	
}
