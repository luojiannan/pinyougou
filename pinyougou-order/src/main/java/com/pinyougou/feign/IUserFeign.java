package com.pinyougou.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author ljn
 * @date 2018/11/2.
 */
@FeignClient("user-server")
public interface IUserFeign {

    @RequestMapping(value = "user/getUser", method = RequestMethod.GET)
    String getUser();
}
