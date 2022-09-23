package com.jackwu.framework.redis.core;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.Duration;

/**
 * Redis Key 定义类
 *
 * @author jackwu
 */
@Data
public class RedisKeyDefine {

    @Getter
    @AllArgsConstructor
    public enum KeyTypeEnum {

        /**
         * String 类型
         */
        STRING("String"),

        /**
         * List 类型
         */
        LIST("List"),

        /**
         * hash 类型
         */
        HASH("Hash"),

        /**
         * set 类型
         */
        SET("Set"),

        /**
         * zset 类型
         */
        ZSET("Sorted Set"),

        /**
         * stream 类型
         */
        STREAM("Stream"),

        /**
         * pub/sub 类型
         */
        PUBSUB("Pub/Sub");

        /**
         * 类型
         */
        @JsonValue
        private final String type;
    }

    @Getter
    @AllArgsConstructor
    public enum TimeoutTypeEnum {

        /**
         * 永不超时
         */
        FOREVER(1),

        /**
         * 动态超时
         */
        DYNAMIC(2),

        /**
         * 固定超时
         */
        FIXED(3);

        /**
         * 类型
         */
        @JsonValue
        private final Integer type;
    }

    /**
     * Key 模板
     */
    private final String keyTemplate;

    /**
     * Key 类型的枚举
     */
    private final KeyTypeEnum keyType;

    /**
     * Value 类型
     * <p>
     * 如果是使用分布式锁，设置为 {@link java.util.concurrent.locks.Lock} 类型
     */
    private final Class<?> valueType;

    /**
     * 超时类型
     */
    private final TimeoutTypeEnum timeoutType;

    /**
     * 过期时间
     */
    private final Duration timeout;

    /**
     * 备注
     */
    private final String memo;

    private RedisKeyDefine(String memo, String keyTemplate, KeyTypeEnum keyType, Class<?> valueType,
            TimeoutTypeEnum timeoutType, Duration timeout) {
        this.memo = memo;
        this.keyTemplate = keyTemplate;
        this.keyType = keyType;
        this.valueType = valueType;
        this.timeout = timeout;
        this.timeoutType = timeoutType;
        // 添加注册表
        RedisKeyRegistry.add(this);
    }

    public RedisKeyDefine(String memo, String keyTemplate, KeyTypeEnum keyType, Class<?> valueType, Duration timeout) {
        this(memo, keyTemplate, keyType, valueType, TimeoutTypeEnum.FIXED, timeout);
    }

    public RedisKeyDefine(String memo, String keyTemplate, KeyTypeEnum keyType, Class<?> valueType, TimeoutTypeEnum timeoutType) {
        this(memo, keyTemplate, keyType, valueType, timeoutType, Duration.ZERO);
    }

    public String formatKey(Object... args) {
        return StrUtil.format(this.keyTemplate, args);
    }
}
