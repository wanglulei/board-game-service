package com.dl.board.game.api.aop;


import com.alibaba.fastjson.JSON;
import com.dl.board.game.common.utils.ContextUtils;
import com.google.common.base.Stopwatch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName ActApiLogAop
 * @Description
 * @Author wanglulei
 * @Date 2020/12/8  18:37
 **/
@Component
@Aspect
@Slf4j
public class ActApiLogAop {

    @Pointcut("execution( * com.dl.board.game.api.http.controller.*.*(..)))")
    public void aopPointCut() {
    }

    @Around("aopPointCut()")
    public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable {
        ContextUtils.getDatas().put("startTime", System.currentTimeMillis());
        Object result;
        Stopwatch stopwatch = Stopwatch.createStarted();
        StringBuilder name = null;
        try {
            name = new StringBuilder(joinPoint.getTarget().getClass().getSimpleName()).append(":").append(joinPoint.getSignature().getName());
            result = joinPoint.proceed();
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            // ip地址
            String ipAddr = getRemoteHost(request);
            // 请求路径
            String requestUrl = request.getRequestURL().toString();
            // 获取请求参数进行打印
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            // 类名
            // swagger中文注释名
            String classCommentName = methodSignature.getMethod().getDeclaringClass().getAnnotation(Api.class).tags()[0];
            String[] sourceName = signature.getDeclaringTypeName().split("\\.");
            String className = sourceName[sourceName.length - 1] + "[" + classCommentName + "]";
            // 方法名
            // swagger中文注释名
            String methodCommentName = methodSignature.getMethod().getAnnotation(ApiOperation.class).value();
            String methodName = signature.getName() + "[" + methodCommentName + "]";
            // 参数名数组
            String[] parameterNames = ((MethodSignature) signature).getParameterNames();
            // 构造参数组集合
            List<Object> argList = new ArrayList<>();
            for (Object arg : joinPoint.getArgs()) {
                // request/response无法使用toJSON
                if (arg instanceof HttpServletRequest) {
                    argList.add("request");
                } else if (arg instanceof HttpServletResponse) {
                    argList.add("response");
                } else {
                    argList.add(JSON.toJSON(arg));
                }
            }
            stopwatch.stop();
            long timeConsuming = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            log.info("请求源IP【{}】 -> 请求URL【{}】\n{} -> {} -> 请求耗时：[{}]毫秒 \n请求参数名：{} \n请求参数： {}\n请求结果：{}",
                    ipAddr, requestUrl,
                    className, methodName, timeConsuming,
                    JSON.toJSON(parameterNames),
                    JSON.toJSON(argList),
                    JSON.toJSON(result));
            return result;
        } catch (Throwable throwable) {
            log.error("接口：" + name + "抛异常");
            throw throwable;
        }
    }

    /**
     * 获取目标主机的ip
     *
     * @param request
     * @return
     */
    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.contains("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }
}
