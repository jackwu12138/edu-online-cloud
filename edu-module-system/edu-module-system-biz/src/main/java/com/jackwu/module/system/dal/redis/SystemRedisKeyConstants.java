package com.jackwu.module.system.dal.redis;

import com.jackwu.framework.redis.core.RedisKeyDefine;

import java.time.Duration;

import static com.jackwu.framework.redis.core.RedisKeyDefine.KeyTypeEnum.STRING;

/**
 * redis key 的模板
 * @author jackwu
 */
public interface SystemRedisKeyConstants {

    RedisKeyDefine CAPTCHA_REDIS_CONSTANTS = new RedisKeyDefine("图片验证码的缓存",
            "captcha: {}",
            STRING, String.class,Duration.ofMinutes(5L));
}
