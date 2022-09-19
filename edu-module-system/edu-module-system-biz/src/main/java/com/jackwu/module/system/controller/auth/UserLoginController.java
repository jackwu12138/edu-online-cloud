package com.jackwu.module.system.controller.auth;


import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户模块 - 验证码
 *
 * @author jackwu
 */
@Api(tags = "系统模块 - 用户登录")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/user-login")
public class UserLoginController {


}
