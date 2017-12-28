package com.gwssi.eoms.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


/**
 * Created by admin on 2017/10/23.
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "produce")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.produce")  // 生产数据源
    public DataSource dataSourceProduce() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "bookConcern")
    @ConfigurationProperties(prefix = "spring.datasource.druid.bookConcern")  // 出版社数据源
    public DataSource dataSourceBookConcern() {
        return DruidDataSourceBuilder.create().build();
    }
}
