package com.jackwu.module.member.controller.user;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.module.member.controller.user.vo.UserCreateRequestVO;
import com.jackwu.module.member.controller.user.vo.UserListResponseVO;
import com.jackwu.module.member.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jackwu.framework.common.pojo.CommonResult.success;

/**
 * 用户模块 - 用户
 *
 * @author jackwu
 */
@Api(tags = "用户模块 - 用户")
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/user")
public class UserController {

    private final UserService service;

    @ApiOperation("创建用户")
    @PostMapping("/create")
    public CommonResult<Long> createUser(@RequestBody UserCreateRequestVO vo) {
        Long id = service.createUser(vo);
        return success(id);
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteUser(@RequestParam Long id) {
        service.deleteUser(id);
        return success(true);
    }

    @ApiOperation("用户信息列表")
    @GetMapping("/list")
    public CommonResult<List<UserListResponseVO>> getUserList() {
        return CommonResult.success(service.getUserList());
    }
}

