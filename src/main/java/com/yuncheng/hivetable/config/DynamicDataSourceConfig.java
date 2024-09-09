package com.yuncheng.hivetable.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.yuncheng.hivetable.utils.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DynamicDataSourceConfig {
    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个
     * @return
     */
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.d1")
    @Bean(name = "first_datasource")
    public DataSource first() {
        return new DruidDataSource();
    }
    @ConfigurationProperties(prefix="spring.datasource.d2")
    @Bean(name = "second_datasource")
    public DataSource second() {
        return new DruidDataSource();
    }

    /**
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     * @param dataSource1    数据源1
     * @param dataSource2   数据源2
     * @return
     */
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dataSource(@Qualifier("first_datasource") javax.sql.DataSource dataSource1,
                                        @Qualifier("second_datasource") DataSource dataSource2){
        Map<Object, Object> dataSourceMap = new HashMap<>(2);
        dataSourceMap.put(DatabaseContextHolder.FIRST_DS,dataSource1);
        dataSourceMap.put(DatabaseContextHolder.SECOND_DS,dataSource2);

        DynamicDataSource dynamicDataSource=new DynamicDataSource();
        //该方法是AbstractRoutingDataSource的方法
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        //根据实际需求，指定默认操作的库
        dynamicDataSource.setDefaultTargetDataSource(dataSource1);
        return dynamicDataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     * @param ds
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        //指定数据源(这个必须有，否则报错)
        fb.setDataSource(ds);
        return fb.getObject();
    }
}
