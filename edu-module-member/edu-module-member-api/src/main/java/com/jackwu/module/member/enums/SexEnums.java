package com.jackwu.module.member.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 姓名的枚举类
 * <p>
 * 放在这里原因是考虑到其他模块没有使用的需求
 *
 * @author jackwu
 */
@Getter
@AllArgsConstructor
public enum SexEnums {

    /**
     * 未知
     */
    UNKNOWN(0),

    /**
     * 男性
     */
    MALE(1),

    /**
     * 女性
     */
    FEMALE(2),
    ;

    private final Integer sex;
}
