package com.dl.board.game.api.http.controller;


import com.dl.board.game.common.response.CommonResp;
import com.dl.board.game.common.utils.ContextUtils;

/**
 * @ClassName GameAbstractController
 * @Description 通用抽象Controller
 * @Author Hmily
 * @Date 2020/2/5 18:18
 **/
public abstract class GameAbstractController {

    public long getCostTime(){
        Object startTimeObj = ContextUtils.getDatas().get(ContextUtils.Constant.KEY_START_TIME);
        if (startTimeObj == null) {
            return -1;
        }

        long startTime = (long) startTimeObj;
        long endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    public CommonResp returnResponse(CommonResp commonResp){
        if (commonResp == null){
            commonResp = CommonResp.business();
        }
        commonResp.setCostTime(getCostTime());
        return commonResp;
    }
}
