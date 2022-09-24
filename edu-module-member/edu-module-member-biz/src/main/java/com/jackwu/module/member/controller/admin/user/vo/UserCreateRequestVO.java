package com.jackwu.module.member.controller.admin.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

/**
 * 用户模块 - 用户 - 创建用户 requestVO
 *
 * @author jackwu
 */
@ApiModel("用户模块 - 用户 - 创建用户 requestVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserCreateRequestVO extends UserBaseVO {

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码", example = "password")
    @Pattern(regexp = "^\\w{4,24}$", message = "密码必须为4-24位之间的数字, 字母, 下划线")
    private String password;
}
