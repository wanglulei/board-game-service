package com.dl.board.game.core.configure;

import com.dl.board.game.common.exception.CheckSignatureException;
import com.dl.board.game.common.response.CommonResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理
 * @Author ouShiMing
 * @Date 2020/6/8 15:30
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(CheckSignatureException.class)
    public CommonResp handleArgument(CheckSignatureException e) {
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        StringBuilder logSb = new StringBuilder();
        String uri = request.getRequestURI();
        logSb.append("url: ");
        logSb.append(uri);
        logSb.append(", error info: ");
        logSb.append(e.getMessage());
        log.error("全局异常拦截: {}", logSb.toString());
        return CommonResp.business(e.getMessage());
    }

}
