package com.jackwu.module.member.convert.user;

import com.jackwu.module.member.controller.user.vo.UserCreateRequestVO;
import com.jackwu.module.member.controller.user.vo.UserListResponseVO;
import com.jackwu.module.member.dal.dataobject.user.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户相关的类型转换器
 *
 * @author jackwu
 */
@Mapper
public interface UserConvert {

    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    /**
     * 将 UserCreateRequestVO 转换为 UserDO
     *
     * @param vo 要转换的 UserCreateRequestVO
     * @return 转换后的 UserDO
     */
    @Mapping(target = "updater", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "loginIp", ignore = true)
    @Mapping(target = "loginDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    UserDO convert(UserCreateRequestVO vo);

    /**
     * 将 UserDO 列表转换为 UserListResponseVO 列表
     *
     * @param users 要转换的 userDO 列表
     * @return 转换后的 UserListResponseVO 列表
     */
    List<UserListResponseVO> convertList(List<UserDO> users);
}