package com.jackwu.module.member.controller.admin.admin.vo;

import com.jackwu.frameword.validation.core.annotation.URL;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户模块 - 管理员 - 更新管理员 requestVO
 *
 * @author jackwu
 */
@ApiModel("用户模块 - 管理员 - 更新管理员 requestVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUpdateRequestVO {

    /**
     * 管理员编号
     */
    @ApiModelProperty(value = "管理员编号", example = "1024")
    @NotNull(message = "管理员编号不能为空")
    private Long id;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称", example = "jackwu")
    @NotNull
    @Size(min = 4, max = 32, message = "昵称长度必须在4-32位之间")
    private String nickname;

    /**
     * 账号状态
     */
    @ApiModelProperty(value = "账号状态", example = "true")
    @NotNull(message = "账号状态不能为空")
    private Boolean status;

    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", example = "https://xxxx/xxx.png")
    @NotNull(message = "头像不能为空")
    @URL
    private String avatar;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "这是一个管理员账号")
    @Length(max = 120, message = "备注最多为 120 个字符")
    private String remark;
}
