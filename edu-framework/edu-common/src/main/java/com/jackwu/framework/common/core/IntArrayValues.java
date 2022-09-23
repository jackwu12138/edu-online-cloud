package com.jackwu.framework.common.core;

/**
 * 可以生成数组的接口, 用于 jsr303 校验
 *
 * @author jackwu
 */
public interface IntArrayValues {

    /**
     * 要进行数据校验的数据集合, 即传递过来的数据应该在返回的数组中
     *
     * @return 数据集合
     */
    int[] toArray();
}
