package com.pinyougou.backend.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author ljn
 * @date 2019/3/1.
 */
@Aspect
@Component
public class FeignExceptionHandler {

    @AfterThrowing(value = "execution(* com.pinyougou.backend.feign..*(..))", throwing = "e")
    public void execution(Throwable e) {
        System.out.println(e);
        throw new RuntimeException(e.getMessage());
    }
}
