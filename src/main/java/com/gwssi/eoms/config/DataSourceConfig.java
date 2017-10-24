package com.gwssi.eoms.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * Created by admin on 2017/10/23.
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "produce")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.produce")  // 生产数据源
    public DataSource dataSourceProduce() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "bookConcern")
    @ConfigurationProperties(prefix = "spring.datasource.bookConcern")  // 出版社数据源
    public DataSource dataSourceBookConcern() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }
}
