package com.jackwu.module.system.service.captcha;

import com.jackwu.module.system.controller.captcha.vo.CaptchaResponseVO;

/**
 * 验证码的 service 接口类
 *
 * @author jackwu
 */
public interface CaptchaService {

    /**
     * 创建验证码
     *
     * @return 验证码图片的 base64 编码
     */
    CaptchaResponseVO generateCaptcha();

    /**
     * 校验验证码
     *
     * @param token 要校验的验证码的 key
     * @param value 验证码的值
     */
    void verifyCaptcha(String token, String value);
}
