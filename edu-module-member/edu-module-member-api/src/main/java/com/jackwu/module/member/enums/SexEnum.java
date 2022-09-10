package com.jackwu.module.member.enums;

import com.jackwu.framework.common.core.IntArrayValues;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * 姓名的枚举类
 * <p>
 * 放在这里原因是考虑到其他模块没有使用的需求
 *
 * @author jackwu
 */
@Getter
@AllArgsConstructor
public enum SexEnum implements IntArrayValues {

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

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(SexEnum::getSex).toArray();

    @Override
    public int[] toArray() {
        return SexEnum.ARRAYS;
    }
}
