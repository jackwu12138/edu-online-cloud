package com.jackwu.framework.web.config;

import com.jackwu.framework.web.core.handler.XssFilter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * web 相关的配置类
 *
 * @author jackwu
 */
@Configuration
@EnableConfigurationProperties({WebProperties.class, XssProperties.class})
public class EduWebAutoConfiguration implements WebMvcConfigurer {

    @Resource
    private WebProperties webProperties;

    /**
     * 创建 XssFilter Bean，解决 Xss 安全问题
     */
    @Bean
    public FilterRegistrationBean<XssFilter> xssFilter(XssProperties properties, PathMatcher mvcPathMatcher) {
        return createFilterBean(new XssFilter(properties, mvcPathMatcher), -102);
    }

    private static <T extends Filter> FilterRegistrationBean<T> createFilterBean(T filter, Integer order) {
        FilterRegistrationBean<T> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(order);
        return bean;
    }
}
