package com.pinyougou.goods.controller;

import com.pinyougou.common.dto.BaseResponse;
import com.pinyougou.goods.dao.entity.Content;
import com.pinyougou.goods.service.IContentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ljn
 * @date 2019/2/15.
 */
@RestController
@RequestMapping("content")
public class ContentController {

    @Autowired
    private IContentService contentService;

    @GetMapping("/findByCategoryId")
    @ApiOperation(value="根据分类id查询广告", notes="根据分类id查询广告")
    public BaseResponse findByCategoryId(Long id) {
        BaseResponse response = new BaseResponse();
        try{
            List<Content> contentList = contentService.findByCategoryId(id);
            response.setData(contentList);
        }catch (Exception e) {
            response.setCode("01");
            response.setErrorMessage("新增品牌发生错误");
        }
        return response;
    }
}
