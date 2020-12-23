package com.dl.board.game.core.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName OtherUrlConfig
 * @Description 获取配置文件中的 URL
 * @Author Hmily
 * @Date 2019/8/4 16:43
 **/

@RefreshScope
@Configuration
@Getter
public class OtherUrlConfig {

}
