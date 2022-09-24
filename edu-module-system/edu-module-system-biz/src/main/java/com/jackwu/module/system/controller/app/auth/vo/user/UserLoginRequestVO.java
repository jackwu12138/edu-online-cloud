package com.jackwu.module.system.controller.app.auth.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

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
public class UserLoginRequestVO {

    @ApiModelProperty(value = "用户名", required = true, example = "username")
    @NotNull(message = "用户名不能为空")
    @Length(max = 30, message = "用户名过长")
    private String username;

    @ApiModelProperty(value = "密码", required = true, example = "password")
    @NotNull(message = "密码不能为空")
    @Length(max = 30, message = "密码过长")
    private String password;

    @ApiModelProperty(value = "验证码的token, 只有开启验证码时需要", example = "username")
    private String token;

    @ApiModelProperty(value = "验证码, 只有开启验证码时需要", example = "username")
    private String code;
}
