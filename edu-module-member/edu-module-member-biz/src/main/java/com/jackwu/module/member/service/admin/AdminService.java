package com.jackwu.module.member.service.admin;

import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.member.controller.admin.admin.vo.AdminCreateRequestVO;
import com.jackwu.module.member.controller.admin.admin.vo.AdminInfoResponseVO;
import com.jackwu.module.member.controller.admin.admin.vo.AdminListResponseVO;
import com.jackwu.module.member.controller.admin.admin.vo.AdminUpdateRequestVO;

/**
 * 管理员信息表的 service 接口
 *
 * @author jackwu
 */
public interface AdminService {

    /**
     * 创建管理员
     *
     * @param vo 要创建的管理员的信息
     * @return 管理员编号
     */
    Long createAdmin(AdminCreateRequestVO vo);

    /**
     * 根据 id 删除管理员
     *
     * @param id 要删除的管理员编号
     */
    void deleteAdmin(Long id);

    /**
     * 更新管理员信息
     *
     * @param vo 要更新的管理员信息
     */
    void updateAdmin(AdminUpdateRequestVO vo);

    /**
     * 获取管理员的分页列表
     *
     * @param param 分页参数
     * @return 管理员分页列表
     */
    PageResult<AdminListResponseVO> getAdminPageList(PageParam param);

    /**
     * 获取用户详细信息
     *
     * @param id 要获取信息的用户编号
     * @return 用户详细信息
     */
    AdminInfoResponseVO getAdminInfo(Long id);
}
