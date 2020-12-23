package com.dl.board.game.common.response;


import com.dl.board.game.common.enums.RespCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@ApiModel(description="通用返回响应")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class CommonResp<T> implements Serializable {

    @ApiModelProperty(value="服务器处理耗时")
    private long costTime;

    @ApiModelProperty(value="返回数据状态")
    private Result result;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ApiModel(description="接口状态")
    public static class Result implements Serializable {
        @ApiModelProperty(value="接口状态")
        private Integer status;

        @ApiModelProperty(value="错误码,0为成功")
        private Integer errorcode;

        @ApiModelProperty(value="错误提示")
        private String msg;
    }

    @ApiModelProperty(value="返回数据")
    private T data;

    public CommonResp(Integer resultCode, String resultMsg) {
        this.result = new Result(1, resultCode, resultMsg);
    }

    public CommonResp(Integer resultCode, String resultMsg, T data) {
        this.result = new Result(1, resultCode, resultMsg);
        this.data = data;
    }

    public static CommonResp needLogin(){
        return new CommonResp(RespCode.NEED_LOGIN.getResultCode(), RespCode.NEED_LOGIN.getResultMsg());
    }

    public static CommonResp business(String resultMsg){
        return new CommonResp(RespCode.BUSINESS_ERROR.getResultCode(), resultMsg);
    }

    public static CommonResp business(){
        return new CommonResp(RespCode.BUSINESS_ERROR.getResultCode(), RespCode.BUSINESS_ERROR.getResultMsg());
    }

    public static CommonResp success(){
        return new CommonResp(RespCode.SUCCESS.getResultCode(), RespCode.SUCCESS.getResultMsg());
    }

    public static CommonResp error(){
        return new CommonResp(RespCode.ERROR.getResultCode(), RespCode.ERROR.getResultMsg());
    }



    public static CommonResp createCommonResp(RespCode RespCode) {
        return new CommonResp(RespCode.getResultCode(), RespCode.getResultMsg());
    }

    public static CommonResp success(String msg){
        return new CommonResp(RespCode.SUCCESS.getResultCode(), msg);
    }

    public static  <T> CommonResp<T> success(T data){
        return new CommonResp(RespCode.SUCCESS.getResultCode(),
                RespCode.SUCCESS.getResultMsg(), data);
    }
}
