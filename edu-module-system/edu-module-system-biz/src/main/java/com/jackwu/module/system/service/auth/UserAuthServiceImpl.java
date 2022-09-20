package com.jackwu.module.system.service.auth;

import com.jackwu.module.system.config.CaptchaProperties;
import com.jackwu.module.system.controller.auth.vo.user.UserLoginRequestVO;
import com.jackwu.module.system.service.captcha.CaptchaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户安全的 service 实现类
 *
 * @author jackwu
 */
@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final CaptchaService captchaService;
    private final CaptchaProperties captchaProperties;

    @Override
    public void userLogin(UserLoginRequestVO vo) {
        // 假如验证码开启, 则要先校验验证码
        if (captchaProperties.getEnable()) {
            captchaService.verifyCaptcha(vo.getToken(), vo.getCode());
        }
        // todo  调用远程服务, 校验密码和用户名
    }
}
