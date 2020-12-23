package com.dl.board.game.api;

import com.dl.board.game.core.configure.datasource.MyDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@ComponentScan(basePackages = {"com.dl.board.game"})
@EnableTransactionManagement
//@EnableAspectJAutoProxy
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class})
//@ImportResource(locations = {"classpath:dubbo.xml"})
@MapperScan(basePackages =  "com.dl.board.game.core.business.**.mapper", sqlSessionFactoryRef = "jiaoxueSqlSessionFactory")
@RestController
@EnableScheduling
@EnableAsync
public class BoardGameApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(BoardGameApplication.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "Hello BoardGameApplication";
    }

}
