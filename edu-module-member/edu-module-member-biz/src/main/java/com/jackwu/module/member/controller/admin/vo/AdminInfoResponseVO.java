package com.jackwu.module.member.controller.admin.vo;

import com.jackwu.framework.jackson.core.annotation.IpAddress;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户模块 - 管理员 - 管理员详细信息 requestVO
 *
 * @author jackwu
 */
@ApiModel("用户模块 - 管理员 - 管理员详细信息 requestVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdminInfoResponseVO extends AdminBaseVO {

    /**
     * 管理员编号
     */
    @ApiModelProperty(value = "管理员编号", example = "1024")
    private Long id;

    /**
     * 管理员类型
     */
    @ApiModelProperty(value = "管理员类型", example = "1")
    public Integer type;

    /**
     * 账号状态
     */
    @ApiModelProperty(value = "账号状态", example = "true")
    private Boolean status;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "我是超级管理员")
    private String remark;

    /**
     * 最后登录IP
     */
    @ApiModelProperty(value = "最后登录IP", example = "127.0.0.1")
    @IpAddress
    private Long loginIp;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间", example = "时间戳格式")
    private LocalDateTime loginDate;
}
