package com.jackwu.module.course.dal.mybatis.article;

import com.jackwu.framework.mybatis.core.mapper.BaseMapperX;
import com.jackwu.module.course.dal.dateobject.article.ArticleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章表的 mapper 接口
 *
 * @author jackwu
 */
@Mapper
public interface ArticleMapper extends BaseMapperX<ArticleDO> {
}
