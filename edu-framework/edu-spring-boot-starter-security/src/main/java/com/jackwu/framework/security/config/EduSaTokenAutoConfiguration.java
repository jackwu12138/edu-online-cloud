package com.jackwu.framework.security.config;

import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.interceptor.SaInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Sa-Token 的拦截器配置
 * <p>
 * 配置该功能后, 才能使用注解进行鉴权
 *
 * @author jackwu
 */
@Configuration
public class EduSaTokenAutoConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
    }

    // -------------------- Sa-Token 的统一配置 -------------------- //

    /**
     * Sa-Token 的统一配置
     * <p>
     * 放在这里的原因是, 不需要在每个模块中单独配置
     */
    @Bean
    @Primary
    public SaTokenConfig getSaTokenConfigPrimary() {
        SaTokenConfig config = new SaTokenConfig();
        // token名称 (同时也是cookie名称)
        config.setTokenName("Authorization");
        // token有效期，单位s
        config.setTimeout(60*60*24*7);
        // token临时有效期 (指定时间内无操作就视为token过期) 单位: 秒
        config.setActivityTimeout(-1);
        // 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录)
        config.setIsConcurrent(false);
        // 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token)
        config.setIsShare(false);
        // token前缀
        config.setTokenPrefix("Bearer");
        // token风格
        config.setTokenStyle("uuid");
        // 输出操作日志
        config.setIsLog(true);
        // 不打印 banner
        config.setIsPrint(false);
        // token 风格
        config.setTokenStyle("simple-uuid");
        return config;
    }
}
