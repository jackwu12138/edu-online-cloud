package com.jackwu.module.system.controller.app.auth;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.module.system.controller.app.auth.vo.user.UserLoginRequestVO;
import com.jackwu.module.system.controller.app.auth.vo.user.UserLoginResponseVO;
import com.jackwu.module.system.service.auth.UserAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.jackwu.framework.common.pojo.CommonResult.success;

/**
 * 用户模块 - app-api - 验证码
 *
 * @author jackwu
 */
@Api(tags = "系统模块 - app-api - 用户登录")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/user-login")
public class UserAuthController {

    private final UserAuthService service;

    @ApiOperation("用户登录")
    @PostMapping("/")
    public CommonResult<UserLoginResponseVO> userLogin(@Valid @RequestBody UserLoginRequestVO vo) {
        return success(service.userLogin(vo));
    }
}
