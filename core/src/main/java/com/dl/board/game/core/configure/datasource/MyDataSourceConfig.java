package com.dl.board.game.core.configure.datasource;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

@Configuration
@Import(DruidConfiguration.class)
@Slf4j
public class MyDataSourceConfig {
    @Autowired
    DruidConfiguration druidConfiguration;

    @Value("${my.mybatis.configLocation}")
    private String configLocation;

    @Value("${my.mybatis.mapperLocations}")
    private String mapperLocations;

    @Value("${my.database.url}")
    private String url;

    @Value("${my.database.username}")
    private String username;

    @Value("${my.database.password}")
    private String password;

    @Value("${my.database.driverClassName}")
    private String driverClass;

    @Value("${my.database.initialSize:3}")
    private int initialSize;

    @Value("${my.database.maxActive:10}")
    private int maxActive;

    @Value("${my.database.maxWait:15000}")
    private int maxWait;

    @Value("${my.database.logAbandoned:true}")
    private boolean logAbandoned;

    @Value("${my.database.removeAbandoned:true}")
    private boolean removeAbandoned;

    @Value("${my.database.removeAbandonedTimeout:600}")
    private int removeAbandonedTimeout;

    @Value("${my.database.testOnBorrow:true}")
    private boolean testOnBorrow;

    @Value("${my.database.validationQuery:select 1}")
    private String validationQuery;

    String connectionInitSqls = "SET NAMES utf8mb4";


    @Bean(name = "myDataSource")
    @Primary
    public DataSource jiaoxueDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        StringTokenizer tokenizer = new StringTokenizer(connectionInitSqls, ";");
        //重点设置该参数(表情处理)
        druidDataSource.setConnectionInitSqls(Collections.list(tokenizer));
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMinIdle(1);
        druidDataSource.setLogAbandoned(true);
        druidDataSource.setRemoveAbandoned(removeAbandoned);
        druidDataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(true);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxOpenPreparedStatements(20);
        druidDataSource.setUseGlobalDataSourceStat(true);
        if(validationQuery!=null && !validationQuery.equals("")){
            druidDataSource.setValidationQuery(validationQuery);
        }
        try {
            druidDataSource.setFilters("stat");
            List<Filter> proxyFilters = new ArrayList<>();
            druidDataSource.setProxyFilters(proxyFilters);
        } catch (SQLException e) {
            log.error("初始化数据源异常",e);
        }
        return druidDataSource;
    }

    @Bean(name = "jiaoxueTransactionManager")
    public DataSourceTransactionManager jiaoxueTransactionManager(@Qualifier("myDataSource") DataSource jiaoxueDataSource) {
        return new DataSourceTransactionManager(jiaoxueDataSource);
    }

    @Bean(name = "jiaoxueSqlSessionFactory")
    public SqlSessionFactory jiaoxueSqlSessionFactory(@Qualifier("myDataSource") DataSource jiaoxueDataSource) throws Exception {
        //解决myBatis下 不能嵌套jar文件的问题
        VFS.addImplClass(SpringBootVFS.class);
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(jiaoxueDataSource);
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:/mybatis-config.xml"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        return sessionFactory.getObject();
    }
}