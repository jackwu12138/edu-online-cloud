package com.jackwu.module.system.controller.captcha.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统模块 - 验证码 - 验证码 response VO
 * @author jackwu
 */
@ApiModel("系统模块 - 验证码 - 验证码 response VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CaptchaResponseVO {

    /**
     * 验证码的 token
     */
    @ApiModelProperty(value = "验证码的 token", example = "7d6cef3ebb834f68b59af3dcc41c0536")
    private String token;

    /**
     * 验证码图片的 base64 编码
     */
    @ApiModelProperty(value = "验证码图片的 base64 编码")
    private String image;
}
