package com.jackwu.module.member.controller.admin.user.vo;

import com.jackwu.frameword.validation.core.annotation.Email;
import com.jackwu.frameword.validation.core.annotation.InEnum;
import com.jackwu.frameword.validation.core.annotation.Mobile;
import com.jackwu.frameword.validation.core.annotation.URL;
import com.jackwu.framework.jackson.core.annotation.Desensitization;
import com.jackwu.framework.jackson.core.enums.DesensitizationType;
import com.jackwu.module.member.enums.SexEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @NotNull(message = "账号不能为空")
    @Pattern(regexp = "^\\w{4,16}$", message = "用户名必须为4-16位之间的数字, 字母, 下划线")
    private String username;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", example = "jackwu")
    @Size(min = 4, max = 32, message = "昵称长度必须在4-32位之间")
    private String nickname;

    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "用户邮箱", example = "jackwu@qq.com")
    @Email
    @Desensitization(DesensitizationType.EMAIL)
    private String email;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", example = "18888888888")
    @Mobile
    @Desensitization(DesensitizationType.MOBILE_PHONE)
    private String mobile;

    /**
     * 用户性别
     */
    @ApiModelProperty(value = "用户性别", example = "未知(0) 男(1) 女(2)")
    @InEnum(SexEnum.class)
    private Integer sex;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", example = "https://xxxx/xxx.png")
    @URL
    private String avatar;
}
