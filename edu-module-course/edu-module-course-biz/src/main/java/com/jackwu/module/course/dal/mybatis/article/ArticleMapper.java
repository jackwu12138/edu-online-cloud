package com.jackwu.module.course.dal.mybatis.article;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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

    /**
     * 根据 id 在数据库中进行查询
     *
     * @param id 文章编号
     * @return 文章内容
     */
    default String selectContentById(Long id) {
        return this.selectOne(new LambdaQueryWrapper<ArticleDO>().select(ArticleDO::getContent).eq(ArticleDO::getId, id)).getContent();
    }
}
