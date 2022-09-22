package com.jackwu.module.system.service.auth;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.jackwu.module.member.api.user.UserApi;
import com.jackwu.module.member.api.user.dto.UserInfoResponseDTO;
import com.jackwu.module.system.config.CaptchaProperties;
import com.jackwu.module.system.controller.auth.vo.user.UserLoginRequestVO;
import com.jackwu.module.system.controller.auth.vo.user.UserLoginResponseVO;
import com.jackwu.module.system.service.captcha.CaptchaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.jackwu.framework.common.util.exception.ServiceExceptionUtil.exception;
import static com.jackwu.module.member.constants.MemberErrorCodeConstants.MEMBER_ERROR_USER_PASSWORD_ERROR;

/**
 * 用户安全的 service 实现类
 *
 * @author jackwu
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final CaptchaService captchaService;
    private final CaptchaProperties captchaProperties;

    // -------------------- 外部服务 -------------------- //

    private final UserApi userApi;

    @Override
    public UserLoginResponseVO userLogin(UserLoginRequestVO vo) {
        // 假如验证码开启, 则要先校验验证码
        if (captchaProperties.getEnable()) {
            captchaService.verifyCaptcha(vo.getToken(), vo.getCode());
        }
        // 调用远程服务, 校验密码和用户名
        UserInfoResponseDTO userinfo = userApi.getUserByUsername(vo.getUsername()).getCheckedData();
        log.debug("userinfo -- {}", userinfo);
        verifyUsernameAndPassword(userinfo, vo.getUsername(), vo.getPassword());
        // 执行登录操作
        StpUtil.login(userinfo.getId());

        // 获取 token 信息
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        return UserLoginResponseVO.builder()
                                  .tokenName(tokenInfo.getTokenName())
                                  .token(tokenInfo.getTokenValue())
                                  .build();
    }

    /**
     * 校验登录时的用户名和密码是否正确
     *
     * @param userinfo 要校验的用户信息
     * @param username 登录的用户名
     * @param password 登录的密码
     */
    private void verifyUsernameAndPassword(UserInfoResponseDTO userinfo, String username, String password) {
        if (ObjectUtil.notEqual(username, userinfo.getUsername())
                || ObjectUtil.notEqual(password, userinfo.getPassword())) {
            throw exception(MEMBER_ERROR_USER_PASSWORD_ERROR);
        }
    }
}
