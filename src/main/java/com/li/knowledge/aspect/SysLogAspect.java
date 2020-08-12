package com.li.knowledge.aspect;

import com.li.knowledge.sys.BaseController;
import com.li.knowledge.utils.http.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class SysLogAspect extends BaseController {


    //第一个 * 号代表匹配所有返回类型
    @Pointcut("execution(public * com.li.knowledge.sys.*.service.*.*.*(..))")
    public void Pointcut(){

    }


    //自定义规则切面
    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println(getLoginName());

        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println(HttpUtils.getClientIp(request));
        log.info("around执行方法之前");
        Object object = pjp.proceed();
        log.info("around执行方法之后--返回值：" +object);
        return object;
    }

    //自定义注解切面
//    @Around("@annotation(syslog)")
//    public Object Around(ProceedingJoinPoint pjp, SysLog syslog) throws Throwable {
//        System.out.println(syslog.type());
//        System.out.println(getLoginName());
//
//        HttpServletRequest request = ((ServletRequestAttributes)
//                RequestContextHolder.getRequestAttributes()).getRequest();
//        System.out.println(HttpUtils.getClientIp(request));
//        log.info("around执行方法之前");
//        Object object = pjp.proceed();
//        log.info("around执行方法之后--返回值：" +object);
//        return object;
//    }

}
