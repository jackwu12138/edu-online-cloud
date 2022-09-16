package com.jackwu.module.member.dal.mybatis.admin;

import com.jackwu.framework.mybatis.core.mapper.BaseMapperX;
import com.jackwu.module.member.dal.dataobject.admin.AdminDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员信息表的 mapper 接口
 *
 * @author jackwu
 */
@Mapper
public interface AdminMapper extends BaseMapperX<AdminDO> {
}
