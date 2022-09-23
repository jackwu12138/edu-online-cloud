package com.jackwu.module.member.dal.dataobject.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jackwu.framework.mybatis.core.dataobject.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@TableName(value = "member_user")
@EqualsAndHashCode(callSuper = true)
public class UserDO extends BaseDO {

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
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 用户性别
     */
    private Integer sex;

    /**
     * 头像地址
     */
    private String avatar;

    /**
     * 账号状态
     */
    private Boolean status;

    /**
     * 最后登录IP
     */
    private Long loginIp;

    /**
     * 最后登录时间
     */
    private LocalDateTime loginDate;
}
