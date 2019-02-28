package com.pinyougou.goods.annotation;

import java.lang.annotation.*;

/**
 * @author ljn
 * @date 2019/2/27.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {

    public String value() default "";

    public long id() default 5L;

}
