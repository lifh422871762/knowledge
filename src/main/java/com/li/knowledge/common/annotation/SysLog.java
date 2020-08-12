package com.li.knowledge.common.annotation;

import java.lang.annotation.*;

/**
 * @description: 系统日志注解
 * @author: wyp
 * @create: 2019-09-08
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    /**
     * 日志类型
     * @return {String}
     */
    int type();
}
