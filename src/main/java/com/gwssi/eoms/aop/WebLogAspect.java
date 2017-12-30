package com.gwssi.eoms.aop;

import jdk.nashorn.internal.scripts.JO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author
 * @create 2017-12-31 02:16
 * Description:
 */

@Slf4j
@Aspect
@Component
public class WebLogAspect {
    /**************************** 以下是controller的日志输出 ********************************/

    @Pointcut("execution(public * com.gwssi.eoms.controller.*.*(..))")  // 要处理的方法，包名+类名+方法名
    public void httpLog() {
    }

    @Before("httpLog()")
    public void doBefore_1(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        log.info("=> 接收到来自IP：" + httpServletRequest.getRemoteAddr() + " 的请求");
        log.info("=> 请求参数：" + Arrays.toString(joinPoint.getArgs()));
        log.info("=> 处理请求的控制器：" + getSelfClassName(joinPoint) + "." + getMethodName(joinPoint));
    }

    @After("httpLog()")  // 无论Controller中调用方法以何种方式结束，都会执行
    public void doAfter_1(JoinPoint joinPoint) {
        log.info("=> 控制器：" + getSelfClassName(joinPoint) + "." + getMethodName(joinPoint) + " 处理完毕");
    }

    @AfterReturning(returning = "obj", pointcut = "httpLog()")  //在调用上面 @Pointcut标注的方法后执行。用于获取返回值
    public void doAfterReturning_1(Object obj) {
        log.info("=> 返回的数据：" + obj.toString());
    }

    @AfterThrowing(pointcut = "httpLog()", throwing = "e")
    public void doThrowing_1(JoinPoint joinPoint, Exception e) {
        log.error("=> 控制器：" + getSelfClassName(joinPoint) + "." + getMethodName(joinPoint) + " 执行时发生异常, 异常详情：" + e);
    }

    /**************************** 以下是service的日志输出 ********************************/

    @Pointcut("execution(public * com.gwssi.eoms.service.*.*.*(..))")  // 要处理的方法，包名+类名+方法名
    public void serviceLog() {
    }

    @Before("serviceLog()")
    public void doBefore_2(JoinPoint joinPoint) {
        log.debug("=> 开始调用 " + getRealClassName(joinPoint) + " 服务，执行 " + getMethodName(joinPoint) + " 方法");
    }

    @After("serviceLog()")  // 无论Controller中调用方法以何种方式结束，都会执行
    public void doAfter_2(JoinPoint joinPoint) {
        log.debug("=> 服务 " + getRealClassName(joinPoint) + "." + getMethodName(joinPoint) + " 执行结束");
    }

    @AfterThrowing(pointcut = "serviceLog()", throwing = "e")
    public void doThrowing_2(JoinPoint joinPoint, Exception e) {
        log.error("=> 调用服务：" + getSelfClassName(joinPoint) + "." + getMethodName(joinPoint) + " 时发生异常, 异常详情：" + e);
    }

    /**
     * 获取自身的类全名
     *
     * @param joinPoint
     * @return
     */
    private String getSelfClassName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringTypeName();
    }

    /**
     * 获取被代理对象的真实类全名
     *
     * @param joinPoint 连接点对象
     * @return 类全名
     */
    private String getRealClassName(JoinPoint joinPoint) {
        return joinPoint.getTarget().getClass().getName();
    }

    /**
     * 获取代理执行的方法名
     *
     * @param joinPoint 连接点对象
     * @return 调用方法名
     */
    private String getMethodName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }
}
