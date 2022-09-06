package com.jackwu.module.member.controller.user.vo;

import com.jackwu.framework.jackson.core.annotation.Desensitization;
import com.jackwu.framework.jackson.core.enums.DesensitizationType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户模块 - 用户 - BaseVO
 * <p>
 * 提供通用字段给子 VO 使用
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBaseVO {

    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户账号", required = true, example = "username")
    private String username;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", example = "jackwu")
    private String nickname;

    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "用户邮箱", example = "jackwu@qq.com")
    @Desensitization(DesensitizationType.EMAIL)
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", example = "18888888888")
    @Desensitization(DesensitizationType.MOBILE_PHONE)
    private String mobile;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "用户性别", example = "未知(0) 男(1) 女(2)")
    private Integer sex;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", example = "https://xxxx/xxx.png")
    private String avatar;
}
