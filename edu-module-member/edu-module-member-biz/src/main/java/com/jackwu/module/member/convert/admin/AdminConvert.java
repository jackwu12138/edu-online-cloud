package com.jackwu.module.member.convert.admin;

import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.member.controller.admin.vo.AdminCreateRequestVO;
import com.jackwu.module.member.controller.admin.vo.AdminInfoResponseVO;
import com.jackwu.module.member.controller.admin.vo.AdminListResponseVO;
import com.jackwu.module.member.controller.admin.vo.AdminUpdateRequestVO;
import com.jackwu.module.member.dal.dataobject.admin.AdminDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 管理员相关的类型转换器
 *
 * @author jackwu
 */
@Mapper(componentModel = "spring")
public interface AdminConvert {

    /**
     * 将 AdminCreateRequestVO 类型转换为 UserDO 类型
     *
     * @param vo 要转换的 AdminCreateRequestVO 类型
     * @return 转换后的 UserDO 类型
     */
    @Mapping(target = "updater", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "loginIp", ignore = true)
    @Mapping(target = "loginDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    AdminDO convert(AdminCreateRequestVO vo);

    /**
     * 将 AdminDO 类型转换为 AdminInfoResponseVO 类型
     *
     * @param admin 要转换的 AdminDo 类型
     * @return 转换后的 AdminInfoResponseVO 类型
     */
    AdminInfoResponseVO convert(AdminDO admin);

    /**
     * 将 AdminUpdateRequestVO 类型转换为 AdminDO 类型
     *
     * @param vo 要转换的 AdminUpdateRequestVO 类型
     * @return 转换后的 AdminDO 类型
     */
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "updater", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "loginIp", ignore = true)
    @Mapping(target = "loginDate", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    AdminDO convert(AdminUpdateRequestVO vo);

    /**
     * 将 AdminDO 类型分页数据转换为 AdminListResponseVO 类型分页数据
     *
     * @param result 要转换的 AdminDO 类型分页数据
     * @return 转换后的 AdminListResponseVO 类型分页数据
     */
    PageResult<AdminListResponseVO> convertPage(PageResult<AdminDO> result);
}
