package com.jackwu.module.course.convert.article;

import com.jackwu.module.course.controller.article.vo.article.ArticleCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleListResponseVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleUpdateRequestVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleUpdateResponseVO;
import com.jackwu.module.course.dal.dateobject.article.ArticleDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 文章相关的类型转换器
 *
 * @author jackwu
 */
@Mapper
public interface ArticleConvert {

    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    /**
     * 将 ArticleDO 转换为 ArticleUpdateResponseVO
     *
     * @param aDo 要转换的 ArticleDO
     * @return 转换后的 ArticleUpdateResponseVO
     */
    ArticleUpdateResponseVO convert(ArticleDO aDo);

    /**
     * 将 ArticleUpdateRequestVO 转换为 ArticleDO
     *
     * @param vo 要转换的 ArticleUpdateRequestVO
     * @return 转换后的 ArticleDO
     */
    @Mapping(target = "updater", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "sales", ignore = true)
    @Mapping(target = "readTime", ignore = true)
    @Mapping(target = "likes", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ArticleDO convert(ArticleUpdateRequestVO vo);

    /**
     * 将 ArticleCreateRequestVO 转换为 ArticleDO
     *
     * @param vo 要转换的 ArticleCreateRequestVO
     * @return 转换后的 ArticleDO
     */
    @Mapping(target = "updater", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "sales", ignore = true)
    @Mapping(target = "readTime", ignore = true)
    @Mapping(target = "likes", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ArticleDO convert(ArticleCreateRequestVO vo);

    /**
     * 将 ArticleDO 列表转换为 ArticleListResponseVO 列表
     *
     * @param articleDos 要转换的 ArticleDO 列表
     * @return 转换后的 ArticleListResponseVO 列表
     */
    @Mapping(target = "typeName", ignore = true)
    List<ArticleListResponseVO> convertList(List<ArticleDO> articleDos);
}
