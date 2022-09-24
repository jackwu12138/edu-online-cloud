package com.jackwu.module.member.service.user;

import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.member.controller.admin.user.vo.UserCreateRequestVO;
import com.jackwu.module.member.controller.admin.user.vo.UserListResponseVO;
import com.jackwu.module.member.dal.dataobject.user.UserDO;

/**
 * 用户信息表的 service 接口
 *
 * @author jackwu
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param vo 要创建的用户信息
     * @return 用户编号
     */
    Long createUser(UserCreateRequestVO vo);

    /**
     * 根据 id 删除用户
     *
     * @param id 要删除的用户编号
     */
    void deleteUser(Long id);

    /**
     * 封禁用户
     *
     * @param id 要封禁的用户 id
     */
    void blockUser(Long id);

    /**
     * 解封用户
     *
     * @param id 要解封的用户 id
     */
    void unblockUser(Long id);

    /**
     * 重置用户的密码
     *
     * @param id 要重置密码的用户 id
     */
    void resetUserPassword(Long id);

    /**
     * 获得用户列表详细信息
     *
     * @param param 分页参数
     * @return 用户列表
     */
    PageResult<UserListResponseVO> getUserPageList(PageParam param);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserDO getUserByUsername(String username);
}

