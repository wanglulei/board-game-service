package com.dl.board.game.common.exception;

/**
 * @ClassName CheckSignatureException
 * @Description phead 校验失败异常
 * @Author ouShiMing
 * @Date 2020/6/30 12:00
 **/
public class CheckSignatureException extends RuntimeException {

    public CheckSignatureException() {
        super("非法请求参数");
    }

    public CheckSignatureException(String message) {
        super(message);
    }
}
