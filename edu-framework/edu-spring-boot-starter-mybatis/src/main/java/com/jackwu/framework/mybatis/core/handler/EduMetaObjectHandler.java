package com.jackwu.framework.mybatis.core.handler;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jackwu.framework.mybatis.core.dataobject.BaseDO;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 通用的参数填充类
 * 自动对继承了 {@link BaseDO} 的类进行参数的自动填充
 *
 * @author jackwu
 */
public class EduMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseDO) {
            BaseDO baseDO = (BaseDO) metaObject.getOriginalObject();

            LocalDateTime current = LocalDateTime.now();
            // 创建时间为空，则以当前时间为插入时间
            if (ObjectUtil.isNotNull(baseDO.getCreateTime())) {
                baseDO.setCreateTime(current);
            }
            // 更新时间为空，则以当前时间为更新时间
            if (ObjectUtil.isNotNull(baseDO.getUpdateTime())) {
                baseDO.setUpdateTime(current);
            }

            // todo 记录创建者
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时间为空，则以当前时间为更新时间
        if (ObjectUtil.isNotNull(metaObject) && metaObject.getOriginalObject() instanceof BaseDO) {
            BaseDO baseDO = (BaseDO) metaObject.getOriginalObject();

            LocalDateTime current = LocalDateTime.now();

            // 更新时间为空，则以当前时间为更新时间
            if (ObjectUtil.isNotNull(baseDO.getUpdateTime())) {
                baseDO.setUpdateTime(current);
            }

            // todo 记录更新者
        }
    }
}
