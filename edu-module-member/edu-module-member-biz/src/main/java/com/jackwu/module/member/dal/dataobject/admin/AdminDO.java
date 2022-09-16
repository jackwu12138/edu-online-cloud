package com.jackwu.module.member.dal.dataobject.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jackwu.framework.mybatis.core.dataobject.BaseDO;
import com.jackwu.module.member.enums.AdminTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户信息表的实体类
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "member_admin")
public class AdminDO extends BaseDO {

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 类型 {@link AdminTypeEnum}
     */
    private Integer type;

    /**
     * 账号状态
     */
    private Boolean status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 最后登录IP
     */
    private Long loginIp;

    /**
     * 最后登录时间
     */
    private LocalDateTime loginDate;
}
