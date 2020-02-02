package com.mybatis.test.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 〈description〉
 * 〈数据源配置〉
 *
 * @author zhixuan.xue
 * @create 2020/2/1 11:45
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        ;
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*Mapper.xml"));
        return factoryBean.getObject();
    }



}
