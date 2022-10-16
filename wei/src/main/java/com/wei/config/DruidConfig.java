package com.wei.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    /**
     * 配置Druid的监控
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DruidDataSource druidDataSource(){

        return new DruidDataSource();
    }
    /**
     * 配置一个管理后台的Servlet
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>(16);
        /** 用户名 */
        //initParams.put("loginUsername", "admin");
        /** 密码  */
        //initParams.put("loginPassword", "admin");
        /** 禁用HTML页面上的“Reset All”功能 */
        initParams.put("resetEnable", "false");
        /** IP白名单 (没有配置或者为空，则允许所有访问) */
        initParams.put("allow", "");
        /** IP黑名单 (存在共同时，deny优先于allow)  initParams.put("deny", "192.168.20.38"); */
        bean.setInitParameters(initParams);
        return bean;
    }
    /**
     * 配置一个web监控的filter
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>(16);
        /** 配置哪些请求忽略 */
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        bean.setInitParameters(initParams);
        /**添加过滤规则 */
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }
}
