package com.dl.board.game.api.http.controller;

import com.dl.board.game.common.request.QueryIndexReq;
import com.dl.board.game.common.response.CommonResp;
import com.dl.board.game.common.response.QueryindexResp;
import com.dl.board.game.core.business.service.IBoardGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

/**
 * @ClassName BoardGameController
 * @Description
 * @Author wanglulei
 * @Date 2020/12/8  18:37
 **/
@RestController
@RequestMapping("/api/game")
@CrossOrigin
@Api(value="BoardGameController",tags={"用户测试接口"})
public class BoardGameController extends GameAbstractController{
    @Autowired
    private IBoardGameService boardGameService;

    @ApiOperation(value = "示例接口", notes = "示例接口", httpMethod = "POST")
    @PostMapping("/test")
    public CommonResp<QueryindexResp> test(@RequestBody QueryIndexReq requestData){
        return returnResponse(CommonResp.success(boardGameService.test(requestData.getName())));
    }
}