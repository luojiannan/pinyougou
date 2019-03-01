package com.pinyougou.frontend.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author ljn
 * @date 2019/2/28.
 */
@Aspect
@Component
public class GlobalExceptionHandler {

    @AfterThrowing(value = "execution(* com.pinyougou.frontend.controller..*(..))", throwing = "e")
    public void execution(Throwable e) {
        System.out.println(e);
        throw new RuntimeException(e.getMessage());
    }
}
