package com.jackwu.module.member.convert.user;

import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.member.api.user.dto.UserInfoResponseDTO;
import com.jackwu.module.member.controller.user.vo.UserCreateRequestVO;
import com.jackwu.module.member.controller.user.vo.UserListResponseVO;
import com.jackwu.module.member.dal.dataobject.user.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 用户相关的类型转换器
 *
 * @author jackwu
 */
@Mapper(componentModel = "spring")
public interface UserConvert {

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
     * 将 UserDO 类型转换为 UserInfoResponseDTO 类型
     *
     * @param user 要转换的 UserDO 类型
     * @return 转换后的 UserInfoResponseDTO 类型
     */
    UserInfoResponseDTO convert(UserDO user);

    /**
     * 将 UserDO 分页列表转换为 UserListResponseVO 分页列表
     *
     * @param users 要转换的 userDO 分页列表
     * @return 转换后的 UserListResponseVO 分页列表
     */
    PageResult<UserListResponseVO> convertPage(PageResult<UserDO> users);
}
