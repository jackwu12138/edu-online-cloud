package com.jackwu.module.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 管理员的类型枚举
 *
 * @author jackwu
 */
@Getter
@AllArgsConstructor
public enum AdminTypeEnum {

    /**
     * 超级管理员
     */
    SUPER_ADMIN("super_admin", 0),

    /**
     * 普通管理员
     */
    ADMIN("admin", 1),
    ;

    /**
     * 类型标识符
     */
    private final String identifier;

    /**
     * 对应的类型值
     */
    private final Integer type;
}
