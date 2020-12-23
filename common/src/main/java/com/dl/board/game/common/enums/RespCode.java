package com.dl.board.game.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum RespCode {
    NEED_LOGIN(-2, "需要登录"),
    ERROR(-1, "服务器繁忙"),
    BUSINESS_ERROR(-3, "参数不正确"),
    VISIT_ACCESS(-4, "访问次数超过限制"),
    ALREADY_RECEIVE(-5, "已经领取过了"),
    INSUFFICIENT(-6, "能量不足"),
    CONTINUALLY(-7, "频繁访问"),
    SUCCESS(0, "处理成功");

    private Integer resultCode;
    private String resultMsg;


}
