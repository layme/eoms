package com.gwssi.eoms.aop;

import com.gwssi.eoms.util.LocalUtils;
import com.gwssi.eoms.util.RestResult;
import jdk.nashorn.internal.scripts.JO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.formula.functions.T;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author
 * @create 2017-12-31 02:16
 * Description:
 */

@Slf4j
@Aspect
@Component
public class WebLogAspect {
    @Autowired
    WebApplicationContext applicationContext;  // 注入上下文

    private List<String> urlList;

    @PostConstruct
    public void getAllUrl(){
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //获取url与类和方法的对应信息
        Map<RequestMappingInfo,HandlerMethod> map = mapping.getHandlerMethods();
        List<String> urlList = new ArrayList<>();
        for (RequestMappingInfo info : map.keySet()){
            //获取url的Set集合，一个方法可能对应多个url
            Set<String> patterns = info.getPatternsCondition().getPatterns();
            for (String url : patterns){
                urlList.add(url);
            }
        }
        this.urlList = urlList;
    }

    /**************************** 以下是controller的日志输出 ********************************/

    @Pointcut("execution(public * com.gwssi.eoms.controller.*.*(..))")  // 要处理的方法，包名+类名+方法名
    public void httpLog() {
    }

    @Before("httpLog()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        if (!this.urlList.contains(httpServletRequest.getRequestURI())) {
            log.error("请求的URI不存在");
        }
    }

    @Around("httpLog()")
    public RestResult<T> around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String randomSequence = LocalUtils.getStringRandom(16);  // 获取随机序列作为唯一标识
        Long startTime = System.currentTimeMillis();  // 记录开始时间

        try {
            resolveRequestAndCheckParam(proceedingJoinPoint);  // 请求校验
        } catch (RuntimeException e) {
            log.error("> 请求参数不合法：{}", e.getMessage());
            log.error("" + e);
            throw e;
        }

        RestResult restResult = null;
        try {
            log.info("> 开始处理 {}", randomSequence);

            restResult = (RestResult)proceedingJoinPoint.proceed();  // 实际业务处理逻辑

            log.info("> {} 处理完毕，耗时：{} ms", randomSequence, System.currentTimeMillis() - startTime);
        } catch (RuntimeException e) {
            log.error("> {} 异常结束，耗时：{} ms，异常详情：{}", randomSequence, System.currentTimeMillis() - startTime, e.getMessage());
            throw e;
        }
        return restResult;
    }

    /**
     * 解析请求信息，并进行参数校验
     * @param joinPoint
     */
    public void resolveRequestAndCheckParam(JoinPoint joinPoint) {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        log.info("> 接收到来自IP：{}", httpServletRequest.getRemoteAddr() + " 的请求");
        log.info("> 请求URI：{}", httpServletRequest.getRequestURI());
        log.info("> 响应控制器：{}.{}", getSelfClassName(joinPoint), getMethodName(joinPoint));
        log.info("> 请求参数：{}", checkParameter(joinPoint));
    }

    @AfterReturning(returning = "obj", pointcut = "httpLog()")  //在调用上面 @Pointcut标注的方法后执行。用于获取返回值
    public void doAfterReturning_1(Object obj) {
        log.info("=> 返回的数据：{}", obj.toString());
    }



    /**************************** 以下是service的日志输出 ********************************/

    @Pointcut("execution(public * com.gwssi.eoms.service.*.*.*(..))")  // 要处理的方法，包名+类名+方法名
    public void serviceLog() {
    }

    @Before("serviceLog()")
    public void doBefore_2(JoinPoint joinPoint) {
        log.debug("=> 开始调用 {} 服务，执行 {} 方法", getRealClassName(joinPoint), getMethodName(joinPoint));
    }

    @After("serviceLog()")  // 无论Controller中调用方法以何种方式结束，都会执行
    public void doAfter_2(JoinPoint joinPoint) {
        log.debug("=> 服务 {}.{} 执行结束", getRealClassName(joinPoint), getMethodName(joinPoint));
    }

    @AfterThrowing(pointcut = "serviceLog()", throwing = "e")
    public void doThrowing_2(JoinPoint joinPoint, Exception e) {
        log.error("=> 调用服务：{}.{} 时发生异常, 异常详情：{}", getSelfClassName(joinPoint), getMethodName(joinPoint), e.getMessage());
    }


    /**************************** 以下是私有公共方法 ********************************/
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

    /**
     * 校验请求参数
     * @param point
     * @return
     */
    private String checkParameter(JoinPoint point) {
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();  // 获取方法的参数列表
        StringBuilder sb = null;
        if (parameterNames.length > 0) {
            sb = new StringBuilder().append("{ ");
            String value = null;
            for (int i = 0; i < parameterNames.length; i++) {
                value = point.getArgs()[i] != null ? point.getArgs()[i].toString() : "null";
                if (point.getArgs()[i] == null) {
                    throw new IllegalArgumentException("参数" + parameterNames[i] + "不能为空");
                }

                if ("requestID".equals(parameterNames[i]) && point.getArgs()[i].toString().length() != 13) {
                    throw new IllegalArgumentException("申请号长度不符");
                }

                sb.append("\"").append(parameterNames[i]).append("\" : \"").append(value).append("\", ");
            }

            sb.setLength(sb.length() - 2);
            sb.append(" }");
        } else {
            sb = new StringBuilder().append("该请求无需参数");
        }
        return sb.toString();
    }
}
