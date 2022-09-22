package com.jackwu.module.member.api.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author jackwu
 */
@ApiModel("用户模块 - RPC - 字典数据 Response DTO")
@Data
@ToString
public class UserInfoResponseDTO {


    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID",example = "1024")
    private Long id;

    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户账号", example = "username")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "password")
    private String password;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", required = true, example = "默认用户4asd58s")
    private String nickname;
}
