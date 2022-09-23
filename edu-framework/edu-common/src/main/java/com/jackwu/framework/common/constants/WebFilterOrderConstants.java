package com.jackwu.framework.common.constants;

/**
 * Web 过滤器顺序的枚举类，保证过滤器按照符合我们的预期
 * <p>
 * 考虑到每个 starter 都需要用到该工具类，所以放到 common 模块下的 enum 包下
 *
 * @author jackwu
 */
public interface WebFilterOrderConstants {

    /**
     * XSS 过滤器
     */
    int XSS_FILTER = -102;
}
