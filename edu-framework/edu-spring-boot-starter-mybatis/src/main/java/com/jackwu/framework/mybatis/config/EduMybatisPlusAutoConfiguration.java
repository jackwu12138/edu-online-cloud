package com.jackwu.framework.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.jackwu.framework.mybatis.core.handler.EduMetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis-Plus 的配置类
 *
 * @author jackwu
 */
@Slf4j
@Configuration
@MapperScan(annotationClass = Mapper.class, basePackages = "com.jackwu.module.*.dal.mybatis")
public class EduMybatisPlusAutoConfiguration {

    /**
     * 自动填充参数类
     */
    @Bean
    public MetaObjectHandler defaultMetaObjectHandler() {
        log.debug("Bean 'EduMetaObjectHandler' configured for use");
        return new EduMetaObjectHandler();
    }

    /**
     * mybatis-plus 的分页插件配置
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        log.debug("Bean 'mybatisPlusInterceptor' configured for use");
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
