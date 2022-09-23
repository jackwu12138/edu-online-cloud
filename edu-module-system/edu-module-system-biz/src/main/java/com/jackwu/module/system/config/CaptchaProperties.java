package com.jackwu.module.system.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 验证码的属性配置
 *
 * @author jackwu
 */
@Data
@Validated
@ConfigurationProperties(prefix = "edu.captcha")
public class CaptchaProperties {

    /**
     * 是否开启验证码, 默认: 开启
     */
    @NotNull
    private Boolean enable = true;

    /**
     * 验证码的长度, 默认: 4
     */
    private Integer length = 4;

    /**
     * 验证码的宽度
     */
    private Integer width = 200;

    /**
     * 验证码的高度
     */
    private Integer height = 400;

    /**
     * 验证码的超时时间(分钟), 默认: 5
     */
    private Integer timeout = 5;
}
