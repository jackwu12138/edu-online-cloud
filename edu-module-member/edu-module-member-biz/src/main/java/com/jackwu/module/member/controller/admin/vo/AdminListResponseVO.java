package com.jackwu.module.member.controller.admin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author jackwu
 */
@ApiModel("用户模块 - 管理员 - 列表 Response VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AdminListResponseVO extends AdminBaseVO {

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
}
