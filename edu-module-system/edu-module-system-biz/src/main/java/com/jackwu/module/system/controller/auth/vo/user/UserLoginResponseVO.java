package com.jackwu.module.system.controller.auth.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 系统模块 - 安全 - 用户登录 response VO
 *
 * @author jackwu
 */
@ApiModel("系统模块 - 安全 - 用户登录 response VO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResponseVO {

    @ApiModelProperty(value = "验证码的token, 只有开启验证码时需要", example = "username")
    private String tokenName;

    @ApiModelProperty(value = "验证码的token, 只有开启验证码时需要", example = "username")
    private String token;
}
