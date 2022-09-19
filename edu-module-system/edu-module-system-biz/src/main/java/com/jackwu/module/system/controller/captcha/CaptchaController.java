package com.jackwu.module.system.controller.captcha;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.module.system.controller.captcha.vo.CaptchaResponseVO;
import com.jackwu.module.system.service.captcha.CaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.jackwu.framework.common.pojo.CommonResult.success;

/**
 * 用户模块 - 验证码
 *
 * @author jackwu
 */
@Api(tags = "系统模块 - 验证码")
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/captcha")
public class CaptchaController {

    private final CaptchaService service;

    @ApiOperation("生成验证码")
    @GetMapping("/generate")
    public CommonResult<CaptchaResponseVO> generateCaptcha() {
        return success(service.generateCaptcha());
    }
}
