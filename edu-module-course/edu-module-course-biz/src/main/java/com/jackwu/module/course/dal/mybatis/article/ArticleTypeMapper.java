package com.jackwu.module.course.dal.mybatis.article;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jackwu.module.course.dal.dateobject.article.ArticleTypeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章分类表的 mapper 接口
 *
 * @author jackwu
 */
@Mapper
public interface ArticleTypeMapper extends BaseMapper<ArticleTypeDO> {

    /**
     * 根据 name 查询字典类型
     *
     * @param name 要查询的name
     * @return 查询到的信息
     */
    default ArticleTypeDO getArticleTypeByName(String name) {
        LambdaQueryWrapper<ArticleTypeDO> wrapper =
                new LambdaQueryWrapper<ArticleTypeDO>()
                        .eq(ArticleTypeDO::getName, name);
        return this.selectOne(wrapper);
    }
}
