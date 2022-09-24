package com.jackwu.module.member.controller.admin.admin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

/**
 * 用户模块 - 管理员 - 创建管理员 requestVO
 *
 * @author jackwu
 */
@ApiModel("用户模块 - 管理员 - 创建管理员 requestVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdminCreateRequestVO extends AdminBaseVO {

    /**
     * 管理员密码
     */
    @ApiModelProperty(value = "密码", example = "password")
    @Pattern(regexp = "^\\w{4,24}$", message = "密码必须为4-24位之间的数字, 字母, 下划线")
    private String password;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "这是一个管理员账号")
    @Length(max = 120, message = "备注最多为 120 个字符")
    private String remark;
}
