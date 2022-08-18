package com.jackwu.module.course.dal.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jackwu.module.course.dal.dateobject.article.ArticleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jackwu
 */
@Mapper
public interface ArticleMapper extends BaseMapper<ArticleDO> {
}
