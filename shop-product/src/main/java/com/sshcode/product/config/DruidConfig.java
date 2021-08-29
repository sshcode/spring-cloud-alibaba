package com.sshcode.product.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.proxy.jdbc.DataSourceProxyConfig;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.sshcode.product.dao")
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name="dataSource")
    public DataSource dataSource(){
        return new DruidDataSource();
    }

    // 注册后台监控页面。SpringBoot 如何注册Servlet
    // 没有web.xml 的情况配置 Servlet 的方法  ： ServletRegistrationBean
    // 测试访问 /drui
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //StatViewServlet   配置后台监控
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> map = new HashMap<>();
        //后台登陆
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        //访问权
        //只允许本地访问
        // map.put("allow","localhost");
        map.put("allow","");//允许所有人

        // map.put("deny","196.168.1.1"); 拒绝ip...访问
        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }
    //过滤器的配置
    //没有web.xml 的情况配置 Filter 的方法！ FilterRegistrationBean
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        // 配置内容
        // 配置哪些请求可以被过滤
        HashMap<String,String>map = new HashMap<>();
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);

        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
