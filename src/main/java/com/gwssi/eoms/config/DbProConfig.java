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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * Created by admin on 2017/10/23.
 */
@Configuration
@Import({DataSourceConfig.class})
@MapperScan(basePackages = DbProConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactoryPro")
public class DbProConfig {
    static final String PACKAGE = "com.gwssi.eoms.dao.produce";
    static final String MAPPER_LOCATION = "classpath:mapper/produce/*/*.xml";

    @Autowired
    @Qualifier("produce")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactoryPro() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(DbProConfig.MAPPER_LOCATION));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplatePro() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryPro()); // 使用上面配置的Factory
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
