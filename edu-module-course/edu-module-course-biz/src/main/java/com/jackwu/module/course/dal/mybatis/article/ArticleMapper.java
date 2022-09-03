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
     * 查询对应的文章类型编号下有多少篇文章
     *
     * @param id 文章类型编号
     * @return 文章数量
     */
    default Long selectArticleCountByTypeId(Long id) {
        LambdaQueryWrapper<ArticleDO> wrapper = new LambdaQueryWrapper<ArticleDO>().eq(ArticleDO::getType, id);

        return this.selectCount(wrapper);
    }
}
