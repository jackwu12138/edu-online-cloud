package com.jackwu.module.system.service.captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.core.lang.UUID;
import com.jackwu.module.system.config.CaptchaProperties;
import com.jackwu.module.system.controller.captcha.vo.CaptchaResponseVO;
import com.jackwu.module.system.dal.redis.captcha.CaptchaRedisDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
            return null;
        }
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(captchaProperties.getWidth(),
                captchaProperties.getHeight(),
                captchaProperties.getLength() ,
                20);
        String value = captcha.getCode();
        String key = UUID.fastUUID().toString(true);
        captchaRedisDao.set(key, value, captchaProperties.getTimeout());
        log.debug("captcha: {} --- {}",key, value );
        return CaptchaResponseVO.builder().token(key).image(captcha.getImageBase64()).build() ;
    }

    @Override
    public void verifyCaptcha(String key, String value) {
        String v = captchaRedisDao.get(key);
        if (v.equals(value)) {
            captchaRedisDao.delete(key);
        }
    }
}
