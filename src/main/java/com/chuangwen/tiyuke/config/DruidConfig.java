package com.chuangwen.tiyuke.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }


    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        Map<String,String> initParam = new HashMap<>();

        initParam.put(StatViewServlet.PARAM_NAME_USERNAME,"root");
        initParam.put(StatViewServlet.PARAM_NAME_PASSWORD,"123");
        initParam.put(StatViewServlet.PARAM_NAME_ALLOW,"");
        initParam.put(StatViewServlet.PARAM_NAME_DENY,"");

        bean.setInitParameters(initParam);

        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();

        initParams.put(WebStatFilter.PARAM_NAME_EXCLUSIONS,"*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
