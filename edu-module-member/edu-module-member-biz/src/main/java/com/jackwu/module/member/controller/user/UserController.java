package com.jackwu.module.member.controller.user;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.member.controller.user.vo.UserCreateRequestVO;
import com.jackwu.module.member.controller.user.vo.UserListResponseVO;
import com.jackwu.module.member.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public CommonResult<Long> createUser(@Valid @RequestBody UserCreateRequestVO vo) {
        Long id = service.createUser(vo);
        return success(id);
    }

    @ApiOperation("根据id删除用户")
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteUser(@RequestParam Long id) {
        service.deleteUser(id);
        return success(true);
    }

    @ApiOperation("用户信息分页列表")
    @GetMapping("/page")
    public CommonResult<PageResult<UserListResponseVO>> getUserPageList(@Valid PageParam param) {
        return CommonResult.success(service.getUserPageList(param));
    }
}

