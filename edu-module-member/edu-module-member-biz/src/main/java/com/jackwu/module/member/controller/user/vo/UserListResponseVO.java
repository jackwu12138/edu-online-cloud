package com.jackwu.module.member.controller.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户模块 - 用户 - 列表 responseVO
 *
 * @author jackwu
 */
@ApiModel("用户模块 - 用户 - 列表 responseVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserListResponseVO extends UserBaseVO {

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID", example = "1024")
    private Long id;

    /**
     * 账号状态
     */
    @ApiModelProperty(value = "账号状态", example = "true")
    private Boolean status;

    /**
     * 最后登录IP
     */
    @ApiModelProperty(value = "最后登录IP", example = "127.0.0.1")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间", example = "时间戳格式")
    private LocalDateTime loginDate;
}
