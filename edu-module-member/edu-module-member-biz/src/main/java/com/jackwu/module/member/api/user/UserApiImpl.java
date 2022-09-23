package com.jackwu.module.member.api.user;

import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.module.member.api.user.dto.UserInfoResponseDTO;
import com.jackwu.module.member.convert.user.UserConvert;
import com.jackwu.module.member.dal.dataobject.user.UserDO;
import com.jackwu.module.member.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

import static com.jackwu.framework.common.pojo.CommonResult.success;
import static com.jackwu.module.member.constants.MemberApiConstants.MEMBER_VERSION;

/**
 * @author jackwu
 */
@RestController
@DubboService(version = MEMBER_VERSION)
@RequiredArgsConstructor
public class UserApiImpl implements UserApi {

    private final UserService service;

    private final UserConvert convertor;

    @Override
    public CommonResult<UserInfoResponseDTO> getUserByUsername(@NotNull String username) {
        UserDO user = service.getUserByUsername(username);
        return success(convertor.convert(user));
    }
}
