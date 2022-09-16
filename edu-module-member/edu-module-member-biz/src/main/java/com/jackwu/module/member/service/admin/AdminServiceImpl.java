package com.jackwu.module.member.service.admin;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.member.controller.admin.vo.AdminCreateRequestVO;
import com.jackwu.module.member.controller.admin.vo.AdminInfoResponseVO;
import com.jackwu.module.member.controller.admin.vo.AdminListResponseVO;
import com.jackwu.module.member.controller.admin.vo.AdminUpdateRequestVO;
import com.jackwu.module.member.convert.admin.AdminConvert;
import com.jackwu.module.member.dal.dataobject.admin.AdminDO;
import com.jackwu.module.member.dal.mybatis.admin.AdminMapper;
import com.jackwu.module.member.enums.AdminTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.jackwu.framework.common.util.exception.ServiceExceptionUtil.exception;
import static com.jackwu.module.member.constants.MemberErrorCodeConstants.MEMBER_ERROR_ADMIN_NOT_FOUND;
import static com.jackwu.module.member.constants.MemberErrorCodeConstants.MEMBER_ERROR_ADMIN_REPEAT;

/**
 * 管理员信息表的 service 实现类
 *
 * @author jackwu
 */
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private static final String DEFAULT_PASSWORD = "123456";

    private final AdminMapper baseMapper;

    private final AdminConvert mapperConvert;

    @Override
    public Long createAdmin(AdminCreateRequestVO vo) {
        this.validateUsernameUnique(null, vo.getUsername());

        AdminDO adminDO = mapperConvert.convert(vo);
        // 设置默认属性
        this.setDefaultProperty(adminDO);
        // 执行插入操作
        this.baseMapper.insert(adminDO);
        return adminDO.getId();
    }

    @Override
    public void deleteAdmin(Long id) {
        this.validateAdminExists(id);

        // 执行删除操作
        this.baseMapper.deleteById(id);
    }

    @Override
    public void updateAdmin(AdminUpdateRequestVO vo) {
        validateAdminExists(vo.getId());

        // 执行更新操作
        AdminDO entity = mapperConvert.convert(vo);
        this.baseMapper.updateById(entity);
    }

    @Override
    public PageResult<AdminListResponseVO> getAdminPageList(PageParam param) {
        PageResult<AdminDO> result = this.baseMapper.selectPage(param, null);

        return this.mapperConvert.convertPage(result);
    }

    @Override
    public AdminInfoResponseVO getAdminInfo(Long id) {
        // 校验是否存在该管理员
        AdminDO admin = this.validateAdminExists(id);

        return mapperConvert.convert(admin);
    }

    /**
     * 校验管理员是否存在
     *
     * @param id 要校验的管理员编号
     * @return 管理员的信息
     */
    public AdminDO validateAdminExists(Long id) {
        // 假如 id 为空则直接返回
        if (ObjectUtil.isNull(id)) {
            return null;
        }
        // 查询对应的管理员数据
        AdminDO admin = this.baseMapper.selectById(id);
        if (ObjectUtil.isNull(admin)) {
            throw exception(MEMBER_ERROR_ADMIN_NOT_FOUND);
        }
        return admin;
    }

    /**
     * 校验管理员的账号唯一
     *
     * @param id       要校验的管理员 id
     * @param username 要校验的管理员账号
     */
    public void validateUsernameUnique(Long id, String username) {
        if (ObjectUtil.isNull(username)) {
            return;
        }
        AdminDO admin = this.baseMapper.selectOne(AdminDO::getUsername, username);

        // 没有查到则之间返回
        if (ObjectUtil.isNull(admin)) {
            return;
        }
        // 如果 id 为 null (执行插入时) 或者 id 和查询到的管理员 id 不相同时
        // 则抛出错误信息
        if (ObjectUtil.isNull(id) || ObjectUtil.notEqual(id, admin.getId())) {
            throw exception(MEMBER_ERROR_ADMIN_REPEAT);
        }
    }

    /**
     * 为新添加的管理员添加默认信息
     *
     * @param admin 管理员信息
     */
    public void setDefaultProperty(AdminDO admin) {
        // 设置默认头像
        if (ObjectUtil.isNull(admin.getAvatar())) {
            admin.setAvatar("http://jackwu-edu-online.oss-cn-chengdu.aliyuncs.com/default-avatar.jpg");
        }
        // 设置默认昵称
        if (ObjectUtil.isNull(admin.getNickname())) {
            String defaultNickname = "管理员" + RandomUtil.randomString(8);
            admin.setNickname(defaultNickname);
        }
        // 设置默认密码
        if (ObjectUtil.isNull(admin.getPassword())) {
            admin.setPassword(DEFAULT_PASSWORD);
        }
        // 默认管理员类型为 管理员类型
        admin.setType(AdminTypeEnum.ADMIN.getType());
    }
}
