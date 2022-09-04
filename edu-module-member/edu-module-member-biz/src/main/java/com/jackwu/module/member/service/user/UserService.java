package com.jackwu.module.member.service.user;

import com.jackwu.module.member.controller.user.vo.UserCreateRequestVO;
import com.jackwu.module.member.controller.user.vo.UserListResponseVO;

import java.util.List;

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
     * 获得用户列表详细信息
     *
     * @return 用户列表
     */
    List<UserListResponseVO> getUserList();
}
