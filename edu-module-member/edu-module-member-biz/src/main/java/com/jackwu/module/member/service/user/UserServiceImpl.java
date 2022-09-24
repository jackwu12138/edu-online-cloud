package com.jackwu.module.member.service.user;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.jackwu.framework.common.exception.ErrorCode;
import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.member.controller.admin.user.vo.UserCreateRequestVO;
import com.jackwu.module.member.controller.admin.user.vo.UserListResponseVO;
import com.jackwu.module.member.convert.user.UserConvert;
import com.jackwu.module.member.dal.dataobject.user.UserDO;
import com.jackwu.module.member.dal.mybatis.user.UserMapper;
import com.jackwu.module.member.enums.SexEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.jackwu.framework.common.util.exception.ServiceExceptionUtil.exception;
import static com.jackwu.module.member.constants.MemberErrorCodeConstants.*;

/**
 * 用户信息表的 service 实现类
 *
 * @author jackwu
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    /**
     * 用户的默认密码
     */
    private static final String DEFAULT_PASSWORD = "123456";

    private final UserMapper baseMapper;

    private final UserConvert mapperConvert;

    @Override
    public Long createUser(UserCreateRequestVO vo) {
        this.checkUpdateOrCreate(null, vo.getUsername(), vo.getMobile(), vo.getEmail());

        UserDO userDO = mapperConvert.convert(vo);
        // 设置默认属性
        this.setDefaultProperty(userDO);
        // 执行插入操作
        this.baseMapper.insert(userDO);
        return userDO.getId();
    }

    @Override
    public void deleteUser(Long id) {
        // 校验 id 是否存在
        this.validateUserExists(id);
        // 执行删除操作
        baseMapper.deleteById(id);
    }

    @Override
    public void blockUser(Long id) {
        // 校验 id 是否存在
        UserDO user = this.validateUserExists(id);
        // 校验是否在未封禁状态
        this.validateUserStatus(user, true);
        // 执行封禁操作
        UserDO updateEntity = new UserDO().setId(id).setStatus(false);
        baseMapper.updateById(updateEntity);
    }

    @Override
    public void unblockUser(Long id) {
        // 校验 id 是否存在
        UserDO user = this.validateUserExists(id);
        // 校验是否在已封禁状态
        this.validateUserStatus(user, false);
        // 执行解封操作
        UserDO updateEntity = new UserDO().setId(id).setStatus(true);
        baseMapper.updateById(updateEntity);
    }

    @Override
    public void resetUserPassword(Long id) {
        // 校验 id 是否存在
        this.validateUserExists(id);
        // 重置用户密码
        UserDO updateEntity = new UserDO().setId(id).setPassword(DEFAULT_PASSWORD);
        baseMapper.updateById(updateEntity);
    }

    @Override
    public UserDO getUserByUsername(String username) {
        return this.baseMapper.selectOne(UserDO::getUsername, username);
    }

    @Override
    public PageResult<UserListResponseVO> getUserPageList(PageParam param) {
        PageResult<UserDO> users = this.baseMapper.selectPage(param, null);

        return mapperConvert.convertPage(users);
    }

    /**
     * 在更新或插入时对数据进行的校验
     *
     * @param id       要校验的用户 id
     * @param username 要校验的用户名
     * @param mobile   要校验的手机号
     * @param email    要校验的邮箱
     */
    private void checkUpdateOrCreate(Long id, String username, String mobile, String email) {
        // 校验是否存在该用户
        this.validateUserExists(id);
        // 校验是否存在用户名, 手机号, 邮箱重复的情况
        this.validateUsernameUnique(id, username);
        this.validateMobileUnique(id, mobile);
        this.validateEmailUnique(id, email);
    }

    /**
     * 校验 id 对应的用户是否存在
     *
     * @param id 要校验的用户 id
     */
    private UserDO validateUserExists(Long id) {
        // 假如 id 为空则直接返回
        if (ObjectUtil.isNull(id)) {
            return null;
        }
        // 查询对应的用户数据
        UserDO userDO = this.baseMapper.selectById(id);
        if (ObjectUtil.isNull(userDO)) {
            throw exception(MEMBER_ERROR_USER_NOT_FOUND);
        }
        return userDO;
    }

    /**
     * 校验用户名是否发生冲突
     *
     * @param id       用户编号
     * @param username 要校验的用户名
     */
    private void validateUsernameUnique(Long id, String username) {
        if (ObjectUtil.isNull(username)) {
            return;
        }
        UserDO user = this.baseMapper.selectOne(UserDO::getUsername, username);
        // 没有查到则之间返回
        if (ObjectUtil.isNull(user)) {
            return;
        }
        // 如果 id 为 null (执行插入时) 或者 id 和查询到的用户 id 不相同时
        // 则抛出错误信息
        if (ObjectUtil.isNull(id) || ObjectUtil.notEqual(id, user.getId())) {
            throw exception(MEMBER_ERROR_USERNAME_REPEAT);
        }
    }

    /**
     * 校验手机号是否发生冲突
     *
     * @param id     用户编号
     * @param mobile 要校验的手机号
     */
    private void validateMobileUnique(Long id, String mobile) {
        if (ObjectUtil.isNull(mobile)) {
            return;
        }
        UserDO user = this.baseMapper.selectOne(UserDO::getMobile, mobile);
        // 没有查到则之间返回
        if (ObjectUtil.isNull(user)) {
            return;
        }
        // 如果 id 为 null (执行插入时) 或者 id 和查询到的用户 id 不相同时
        // 则抛出错误信息
        if (ObjectUtil.isNull(id) || ObjectUtil.notEqual(id, user.getId())) {
            throw exception(MEMBER_ERROR_MOBILE_REPEAT);
        }
    }

    /**
     * 校验邮箱是否发生冲突
     *
     * @param email 邮箱
     */
    private void validateEmailUnique(Long id, String email) {
        if (ObjectUtil.isNull(email)) {
            return;
        }
        UserDO user = this.baseMapper.selectOne(UserDO::getEmail, email);
        // 没有查到则之间返回
        if (ObjectUtil.isNull(user)) {
            return;
        }
        // 如果 id 为 null (执行插入时) 或者 id 和查询到的用户 id 不相同时
        // 则抛出错误信息
        if (ObjectUtil.isNull(id) || ObjectUtil.notEqual(id, user.getId())) {
            throw exception(MEMBER_ERROR_EMAIL_REPEAT);
        }
    }

    /**
     * 设置用户的默认属性
     * <p>
     * todo 默认信息应该改为可配置的 从system配置模块读取, 或者在配置文件中
     *
     * @param user 用户信息
     */
    private void setDefaultProperty(UserDO user) {
        // 设置默认头像
        if (ObjectUtil.isNull(user.getAvatar())) {
            user.setAvatar("http://jackwu-edu-online.oss-cn-chengdu.aliyuncs.com/default-avatar.jpg");
        }
        // 设置默认昵称
        if (ObjectUtil.isNull(user.getNickname())) {
            String defaultNickname = "默认用户" + RandomUtil.randomString(8);
            user.setNickname(defaultNickname);
        }
        // 设置默认密码
        if (ObjectUtil.isNull(user.getPassword())) {
            user.setPassword(DEFAULT_PASSWORD);
        }
        // 设置默认性别 - 默认为未知
        if (ObjectUtil.isNull(user.getSex())) {
            user.setSex(SexEnum.UNKNOWN.getSex());
        }
    }

    /**
     * 校验用户的账号状态
     *
     * @param user   用户信息
     * @param status 状态
     */
    private void validateUserStatus(UserDO user, boolean status) {
        if (ObjectUtil.isNull(user)) {
            throw exception(MEMBER_ERROR_USER_NOT_FOUND);
        }
        // 假如账号状态不对应
        if (ObjectUtil.notEqual(user.getStatus(), status)) {
            ErrorCode errorCode = user.getStatus() ? MEMBER_ERROR_USER_ALREADY_UNBLOCKED : MEMBER_ERROR_USER_ALREADY_BANNED;
            throw exception(errorCode);
        }
    }
}

