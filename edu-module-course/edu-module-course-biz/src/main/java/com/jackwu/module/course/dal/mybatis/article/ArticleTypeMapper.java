package com.jackwu.module.course.dal.mybatis.article;

import com.jackwu.framework.mybatis.core.mapper.BaseMapperX;
import com.jackwu.module.course.dal.dateobject.article.ArticleTypeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章分类表的 mapper 接口
 *
 * @author jackwu
 */
@Mapper
public interface ArticleTypeMapper extends BaseMapperX<ArticleTypeDO> {
}
