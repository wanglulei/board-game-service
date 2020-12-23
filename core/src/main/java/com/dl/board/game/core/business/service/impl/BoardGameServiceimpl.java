package com.dl.board.game.core.business.service.impl;

import com.dl.board.game.common.response.QueryindexResp;
import com.dl.board.game.common.vo.TJsonVo;
import com.dl.board.game.core.business.entity.TJson;
import com.dl.board.game.core.business.example.TJsonExample;
import com.dl.board.game.core.business.mapper.TJsonMapper;
import com.dl.board.game.core.business.service.IBoardGameService;
import com.dl.board.game.core.configure.JedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName BoardGameServiceimpl
 * @Description
 * @Author wanglulei
 * @Date 2020/12/8  18:17
 **/
@Service
@Slf4j
public class BoardGameServiceimpl implements IBoardGameService {
    @Autowired
    private TJsonMapper tJsonMapper;

    @Override
    public QueryindexResp test(String name) {
        String key = "board-game-test";
        JedisUtils.set(key,name);
        TJson tJson = tJsonMapper.selectOneByExample(new TJsonExample().createCriteria().andSnameEqualTo(name).example());
        TJsonVo tJsonVo = null;
        if (tJson != null){
            tJsonVo = TJsonVo.builder()
                    .id(tJson.getId())
                    .sname(tJson.getSname())
                    .info(tJson.getInfo())
                    .build();
        }
        return QueryindexResp.builder().
                name(name)
                .dbInfo(tJsonVo)
                .redisInfo(JedisUtils.get(key))
                .build();
    }
}