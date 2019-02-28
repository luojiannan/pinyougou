package com.pinyougou.goods.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author ljn
 * @date 2019/2/28.
 */
@Aspect
@Component
public class BrandAspect {

    /**
     * 前置通知
     */

    @Before("execution(* com.pinyougou.goods.service.impl.BrandServiceImpl.createBrand(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("添加品牌前置处理");
    }

    /**
     * 后置通知
     * @param result
     */
    @AfterReturning(value = "execution(* com.pinyougou.goods.service.impl.BrandServiceImpl.batchDelete(..))",returning = "result")
    public void afterReturningAdvice(Object result) {
        System.out.println("删除品牌后置处理" + result);
    }

    /**
     * 环绕通知
     * @param proceedingjoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* com.pinyougou.goods.service.impl.BrandServiceImpl.updateBrand(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingjoinPoint) throws Throwable {
        System.out.println("修改品牌，前置处理");
        Object proceed = proceedingjoinPoint.proceed();
        System.out.println("修改品牌,后置处理");
        return proceed;
    }

    /**
     * 最终通知
     */
    @After(value = "execution(* com.pinyougou.goods.service.impl.BrandServiceImpl.findById(..))")
    public void afterAdvice() {
        System.out.println("查找品牌，最终通知处理");
    }

    /**
     * 抛出异常通知
     * @param e
     */
    @AfterThrowing(value = "execution(* com.pinyougou.goods.service.impl.BrandServiceImpl.selectOptionList(..))", throwing = "e")
    public void throwExceptionAdvice(Throwable e){
        System.out.println("抛出异常通知"+ e.getMessage());
    }

}
