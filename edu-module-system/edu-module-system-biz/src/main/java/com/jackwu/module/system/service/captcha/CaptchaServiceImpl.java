package com.jackwu.module.system.service.captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.jackwu.module.system.config.CaptchaProperties;
import com.jackwu.module.system.controller.app.captcha.vo.CaptchaResponseVO;
import com.jackwu.module.system.dal.redis.captcha.CaptchaRedisDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.jackwu.framework.common.util.exception.ServiceExceptionUtil.exception;
import static com.jackwu.module.system.constants.SystemErrorCodeConstants.*;

/**
 * 验证码的 service 实现类
 *
 * @author jackwu
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {

    private final CaptchaProperties captchaProperties;

    private final CaptchaRedisDao captchaRedisDao;

    @Override
    public CaptchaResponseVO generateCaptcha() {
        if (!captchaProperties.getEnable()) {
            throw exception(SYSTEM_ERROR_NOT_ENABLE);
        }
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(captchaProperties.getWidth(),
                captchaProperties.getHeight(),
                captchaProperties.getLength(),
                20);
        String value = captcha.getCode();
        String key = UUID.fastUUID().toString(true);
        captchaRedisDao.set(key, value, captchaProperties.getTimeout());
        log.debug("captcha: {} --- {}", key, value);
        return CaptchaResponseVO.builder().token(key).image(captcha.getImageBase64()).build();
    }

    @Override
    public void verifyCaptcha(String key, String value) {
        String code = captchaRedisDao.get(key);
        // 假如验证码不存在
        if (StrUtil.isEmptyIfStr(code)) {
            throw exception(SYSTEM_ERROR_CAPTCHA_NOT_FOUND);
        }
        captchaRedisDao.delete(key);
        // 验证码错误
        if (ObjectUtil.notEqual(code, value)) {
            throw exception(SYSTEM_ERROR_CAPTCHA_ERROR);
        }
    }
}
