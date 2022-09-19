package com.jackwu.module.system.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 验证码的配置类
 *
 * @author jackwu
 */
@Configuration
@EnableConfigurationProperties({CaptchaProperties.class})
public class CaptchaConfiguration {
}
