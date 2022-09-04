package com.jackwu.module.member.dal.mybatis.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jackwu.module.member.dal.dataobject.user.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表的 mapper 接口
 *
 * @author jackwu
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 根据用户名查询一条信息
     *
     * @param username 要查询的用户名
     * @return 查询到的用户信息
     */
    default UserDO selectOneByUsername(String username) {
        return this.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUsername, username));
    }

    /**
     * 根据手机号查询一条信息
     *
     * @param mobile 要查询的手机号
     * @return 查询到的用户信息
     */
    default UserDO selectOneByMobile(String mobile) {
        return this.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getMobile, mobile));
    }

    /**
     * 根据邮箱查询一条信息
     *
     * @param email 要查询的邮箱
     * @return 查询到的用户信息
     */
    default UserDO selectOneByEmail(String email) {
        return this.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getEmail, email));
    }
}
