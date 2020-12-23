package com.dl.board.game.api.http.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @ClassName TaskController
 * @Description 定时任务
 * @Author wanglulei
 * @Date 2020/5/18  10:32
 **/

@RestController
@RequestMapping("/taskController")
@CrossOrigin
@EnableScheduling
@Slf4j
@Api(value = "定时任务TaskController", tags = {"定时任务接口"})
public class TaskController extends GameAbstractController{

}