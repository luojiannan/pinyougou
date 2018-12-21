package com.pinyougou.backend.feign;

import com.pinyougou.common.dto.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ljn
 * @date 2018/11/6.
 */
@FeignClient("user-server")
@Component
public interface IUserFeign {

    @RequestMapping(value = "user/getUser", method = RequestMethod.GET)
    String getUser();

    @RequestMapping(value = "user/findByName", method = RequestMethod.GET)
    BaseResponse findByName(@RequestParam("userName") String userName);

    @RequestMapping(value = "user/login", method = RequestMethod.GET)
    BaseResponse login(@RequestParam("userName") String userName, @RequestParam("password") String password);
}
