package com.jackwu.module.course.dal.mybatis.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jackwu.module.course.dal.dateobject.article.ArticleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章表的 mapper 接口
 *
 * @author jackwu
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleDO> {
}
