package com.jackwu.module.system.dal.redis.captcha;

import com.jackwu.module.system.dal.redis.SystemRedisKeyConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;

/**
 * @author jackwu
 */
@Repository
@RequiredArgsConstructor
public class CaptchaRedisDao {

    private final StringRedisTemplate redisTemplate;

    /**
     * 在 redis 中插入验证码的值
     *
     * @param key     验证码的 key
     * @param value   验证码的 value
     * @param timeout 验证码的超时时间
     */
    public void set(String key, String value, Integer timeout) {
        key = SystemRedisKeyConstants.CAPTCHA_REDIS_CONSTANTS.formatKey(key);
        redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(timeout));
    }

    /**
     * 获取对应的验证码的值
     *
     * @param key 要获取的验证码的 key
     * @return 验证码的值
     */
    public String get(String key) {
        key = SystemRedisKeyConstants.CAPTCHA_REDIS_CONSTANTS.formatKey(key);
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除对应的验证码
     *
     * @param key 要删除的验证码的 key
     */
    public void delete(String key) {
        key = SystemRedisKeyConstants.CAPTCHA_REDIS_CONSTANTS.formatKey(key);
        redisTemplate.delete(key);
    }
}
