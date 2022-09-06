package com.jackwu.framework.jackson.core.enums;

import cn.hutool.core.util.DesensitizedUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Function;

/**
 * 数据脱敏的策略
 * <p>
 * 目前可配置的策略有:
 * <ol>
 *     <li>NONE 不进行数据脱敏</li>
 *     <li>MOBILE_PHONE 手机号脱敏策略</li>
 *     <li>EMAIL 邮箱脱敏策略</li>
 *     <li>PASSWORD 密码脱敏策略</li>
 * </ol>
 *
 * @author jackwu
 */
@Getter
@AllArgsConstructor
public enum DesensitizationType {

    /**
     * 不进行数据脱敏
     */
    NONE(s -> s),

    /**
     * 手机号脱敏
     */
    MOBILE_PHONE(DesensitizedUtil::mobilePhone),

    /**
     * 邮箱脱敏
     */
    EMAIL(DesensitizedUtil::email),

    /**
     * 密码脱敏
     */
    PASSWORD(DesensitizedUtil::password);

    private final Function<String, String> type;
}
