package com.jackwu.module.system.service.auth;

import com.jackwu.module.system.controller.auth.vo.user.UserLoginRequestVO;

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
     */
    void userLogin(UserLoginRequestVO vo);
}
