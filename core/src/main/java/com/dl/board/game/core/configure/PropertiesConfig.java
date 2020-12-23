package com.dl.board.game.core.configure;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName PropertiesConfig
 * @Description 一些属性配置
 * @Author ouShiMing
 * @Date 2020/6/23 16:11
 **/

@RefreshScope
@Configuration
@Getter
public class PropertiesConfig {

    @Value("${spring.profiles.active}")
    private String profilesActive;

}
