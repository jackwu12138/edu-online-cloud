package com.jackwu.module.member.controller.admin.vo;

import com.jackwu.frameword.validation.core.annotation.URL;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * 用户模块 - 管理员 - BaseVO
 * <p>
 * 提供通用字段给子 VO 使用
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminBaseVO {

    /**
     * 管理员账号
     */
    @ApiModelProperty(value = "管理员账号", required = true, example = "username")
    @NotNull(message = "账号不能为空")
    @Pattern(regexp = "^\\w{4,16}$", message = "用户名必须为4-16位之间的数字, 字母, 下划线")
    private String username;

    /**
     * 管理员昵称
     */
    @ApiModelProperty(value = "昵称", example = "jackwu")
    @Size(min = 4, max = 32, message = "昵称长度必须在4-32位之间")
    private String nickname;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", example = "https://xxxx/xxx.png")
    @URL
    private String avatar;
}
