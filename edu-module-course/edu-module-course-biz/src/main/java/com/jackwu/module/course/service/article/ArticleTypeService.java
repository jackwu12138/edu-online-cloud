package com.jackwu.module.course.service.article;

import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeResponseVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeSimpleResponseVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeUpdateRequestVO;

import java.util.List;

/**
 * 文章分类表的 service 接口
 *
 * @author jackwu
 */
public interface ArticleTypeService {

    /**
     * 添加一条文章类型记录到表中
     *
     * @param requestVO 文章类型信息
     * @return 文章类型编号
     */
    Long createArticleType(ArticleTypeCreateRequestVO requestVO);

    /**
     * 删除指定 id 的文章分类
     *
     * @param id 要删除的文章分类 id
     */
    void deleteArticleTypeById(Long id);

    /**
     * 更新文章类型信息
     *
     * @param requestVO 文章类型信息数据
     */
    void updateArticleType(ArticleTypeUpdateRequestVO requestVO);

    /**
     * 获取所有启用的文章类型信息的精简列表
     *
     * @return 精简列表
     */
    List<ArticleTypeSimpleResponseVO> getSimpleArticleTypeList();

    /**
     * 获取所有的文章分类信息, 包括未启用的
     *
     * @return 文章分类信息
     */
    List<ArticleTypeResponseVO> getArticleTypeList();
}
