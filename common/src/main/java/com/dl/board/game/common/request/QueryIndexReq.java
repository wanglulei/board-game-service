package com.dl.board.game.common.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName QueryIndexReq
 * @Description
 * @Author wanglulei
 * @Date 2020/12/8  18:28
 **/
@Data
@ApiModel(description="查询首页")
@AllArgsConstructor
@NoArgsConstructor
public class QueryIndexReq implements Serializable {

    @ApiModelProperty(value="名称")
    private String name;
}