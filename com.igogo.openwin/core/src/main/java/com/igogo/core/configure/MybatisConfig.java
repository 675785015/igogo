package com.igogo.core.configure;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Lee on 2017/4/26.
 */
@Configuration
@MapperScan(basePackages= "com.igogo.core.mapper")
public class MybatisConfig {

    @Autowired
    Environment env;

    @Bean
    public DataSource getDataSource() throws Exception {
        Properties prop = new Properties();

        prop.put("driverClassName", env.getProperty("jdbc.driverClassName"));
        prop.put("url", env.getProperty("jdbc.url"));
        prop.put("username", env.getProperty("jdbc.username"));
        prop.put("password", env.getProperty("jdbc.password"));

        return DruidDataSourceFactory.createDataSource(prop);
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        bean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));
        return bean.getObject();
    }
}
