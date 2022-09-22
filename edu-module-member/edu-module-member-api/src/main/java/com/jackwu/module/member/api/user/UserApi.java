package com.jackwu.module.member.api.user;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.module.member.api.user.dto.UserInfoResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.jackwu.module.member.constants.MemberApiConstants.MEMBER_APPLICATION_NAME;
import static com.jackwu.module.member.constants.MemberApiConstants.MEMBER_PREFIX;

/**
 * 用户模块 - RPC - 用户
 *
 * @author jackwu
 */
@Api(tags = "用户模块 - RPC - 用户")
@FeignClient(name = MEMBER_APPLICATION_NAME)
public interface UserApi {

    String PREFIX = MEMBER_PREFIX + "/user";

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping(PREFIX + "/login")
    @ApiOperation("根据用户名获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", example = "username", required = true, dataTypeClass = String.class),
    })
    CommonResult<UserInfoResponseDTO> getUserByUsername(@RequestParam("username") String username);
}
