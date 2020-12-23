package com.dl.board.game.common.response;

import com.dl.board.game.common.vo.TJsonVo;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName QueryindexResp
 * @Description
 * @Author wanglulei
 * @Date 2020/12/8  18:29
 **/

@Data
@Builder
@ApiModel(description="首页返回数据")
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class QueryindexResp  implements Serializable {
    
    private static final long serialVersionUID = -7820780007115060994L;

    @ApiModelProperty(value="返回信息")
    private String name;

    @ApiModelProperty(value="数据库信息")
    private TJsonVo dbInfo;

    @ApiModelProperty(value="redis信息")
    private String redisInfo;
}