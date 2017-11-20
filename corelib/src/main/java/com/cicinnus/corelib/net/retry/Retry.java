package com.cicinnus.corelib.net.retry;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by zhongrongguang on 2017/9/29.
 * 重试注解,方法注解,参数为count
 */

@Documented
@Retention(RUNTIME)
@Target(ElementType.METHOD)
public @interface Retry {
    int count() default 0;

}
