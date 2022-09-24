package com.jackwu.module.member.controller.admin.admin;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.member.controller.admin.admin.vo.AdminCreateRequestVO;
import com.jackwu.module.member.controller.admin.admin.vo.AdminInfoResponseVO;
import com.jackwu.module.member.controller.admin.admin.vo.AdminListResponseVO;
import com.jackwu.module.member.controller.admin.admin.vo.AdminUpdateRequestVO;
import com.jackwu.module.member.service.admin.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.jackwu.framework.common.pojo.CommonResult.success;

/**
 * 用户模块 - admin-api - 管理员
 *
 * @author jackwu
 */
@Api(tags = "用户模块 - admin-api - 管理员")
@RestController
@RequiredArgsConstructor
@RequestMapping("/member/admin")
public class AdminController {

    private final AdminService service;

    @ApiOperation("创建管理员")
    @PostMapping("/create")
    public CommonResult<Long> createAdmin(@Valid @RequestBody AdminCreateRequestVO vo) {
        Long id = service.createAdmin(vo);
        return success(id);
    }

    @ApiOperation("删除管理员")
    @DeleteMapping("/delete")
    public CommonResult<Boolean> deleteAdmin(@RequestParam Long id) {
        service.deleteAdmin(id);
        return success(true);
    }

    @ApiOperation("更新管理员")
    @PutMapping("/update")
    public CommonResult<Boolean> updateAdmin(@RequestBody AdminUpdateRequestVO vo) {
        service.updateAdmin(vo);
        return success(true);
    }

    @ApiOperation("管理员分页列表")
    @GetMapping("/page")
    public CommonResult<PageResult<AdminListResponseVO>> getAdminPageList(@Valid PageParam param) {
        return success(service.getAdminPageList(param));
    }

    @ApiOperation("获得管理员详细信息")
    @GetMapping("/info/{id}")
    public CommonResult<AdminInfoResponseVO> getAdminInfo(@PathVariable Long id) {
        return success(service.getAdminInfo(id));
    }
}
