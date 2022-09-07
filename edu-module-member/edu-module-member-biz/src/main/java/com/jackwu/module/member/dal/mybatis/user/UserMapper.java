package com.jackwu.module.member.dal.mybatis.user;

import com.jackwu.framework.mybatis.core.mapper.BaseMapperX;
import com.jackwu.module.member.dal.dataobject.user.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表的 mapper 接口
 *
 * @author jackwu
 */
@Mapper
public interface UserMapper extends BaseMapperX<UserDO> {

}
