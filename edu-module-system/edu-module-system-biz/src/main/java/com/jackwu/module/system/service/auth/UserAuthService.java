package com.jackwu.module.system.service.auth;

import com.jackwu.module.system.controller.app.auth.vo.user.UserLoginRequestVO;
import com.jackwu.module.system.controller.app.auth.vo.user.UserLoginResponseVO;

/**
 * 用户安全的 service 接口类
 *
 * @author jackwu
 */
public interface UserAuthService {

    /**
     * 用户登录
     *
     * @param vo 要进行登录操作的用户信息
     * @return 返回的用户 token
     */
    UserLoginResponseVO userLogin(UserLoginRequestVO vo);
}
