package com.jackwu.module.course.convert.article;

import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeResponseVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeUpdateRequestVO;
import com.jackwu.module.course.dal.dateobject.article.ArticleTypeDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 文章类型相关的类型转换器
 *
 * @author jackwu
 */
@Mapper
public interface ArticleTypeConvert {

    ArticleTypeConvert INSTANCE = Mappers.getMapper(ArticleTypeConvert.class);

    /**
     * 将 ArticleTypeCreateRequestVO 类型转换为 ArticleTypeDO 类型
     *
     * @param requestVO 要转换 ArticleTypeCreateRequestVO 类型
     * @return 转换后的 ArticleTypeDO 类型
     */
    @Mapping(target = "updater", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ArticleTypeDO convert(ArticleTypeCreateRequestVO requestVO);

    /**
     * 将 ArticleTypeUpdateRequestVO 类型转换为 ArticleTypeDO 类型
     *
     * @param requestVO 要转换的 ArticleTypeUpdateRequestVO 类型
     * @return 转换后的 ArticleTypeDO 类型
     */
    @Mapping(target = "updater", ignore = true)
    @Mapping(target = "updateTime", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "creator", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    ArticleTypeDO convert(ArticleTypeUpdateRequestVO requestVO);

    /**
     * 将 ArticleTypeDO 列表转换为 ArticleTypeResponseVO 列表
     *
     * @param articleTypeDos 要转换的 ArticleTypeDO 列表
     * @return 转换后的 ArticleTypeResponseVO 列表
     */
    List<ArticleTypeResponseVO> convertList(List<ArticleTypeDO> articleTypeDos);
}
