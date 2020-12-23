package com.dl.board.game.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName QueryindexResp
 * @Description
 * @Author wanglulei
 * @Date 2020/12/8  18:29
 **/

@Data
@Builder
@ApiModel(description="用户基本信息")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TJsonVo implements Serializable {
    private static final long serialVersionUID = -965777748282542149L;

    @ApiModelProperty(value="ID")
    Integer id;

    @ApiModelProperty(value="名称")
    private String sname;

    @ApiModelProperty(value="info")
    private String info;
}
