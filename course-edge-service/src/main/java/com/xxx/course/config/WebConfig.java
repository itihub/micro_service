package com.xxx.course.config;

import com.xxx.course.filter.CourseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**过滤器注册*/
    @Bean
    public FilterRegistrationBean registrationBean(CourseFilter courseFilter) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //注册自定义过滤器
        registrationBean.setFilter(courseFilter);

        //设置过滤器起作用的路径
        List<String> urls = new ArrayList<>();
        urls.add("/*");

        registrationBean.setUrlPatterns(urls);

        return registrationBean;

    }
}
