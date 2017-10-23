package com.gwssi.eoms.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Created by admin on 2017/10/23.
 */
@Configuration
@Import({DataSourceConfig.class})
@MapperScan(basePackages = {"com.gwssi.eoms.dao.bookConcern"}, sqlSessionFactoryRef = "sqlSessionFactoryBco")
public class DbBcoConfig {
    static final String PACKAGE = "com.gwssi.eoms.dao.bookConcern";
    static final String MAPPER_LOCATION = "classpath:mapper/bookConcern/*.xml";

    @Autowired
    @Qualifier("bookConcern")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryBco() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DbBcoConfig.MAPPER_LOCATION));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateBco() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryBco()); // 使用上面配置的Factory
        return template;
    }
}
