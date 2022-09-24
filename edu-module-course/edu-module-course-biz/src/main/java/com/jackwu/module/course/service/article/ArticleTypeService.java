package com.jackwu.module.course.service.article;

import com.jackwu.module.course.controller.admin.article.vo.articletype.ArticleTypeCreateRequestVO;
import com.jackwu.module.course.controller.admin.article.vo.articletype.ArticleTypeResponseVO;
import com.jackwu.module.course.controller.admin.article.vo.articletype.ArticleTypeSimpleResponseVO;
import com.jackwu.module.course.controller.admin.article.vo.articletype.ArticleTypeUpdateRequestVO;

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

    /**
     * 根据 id 查询文章类型名
     *
     * @param id 要查询的 id
     * @return 文章类型名, 未查询到时返回 null
     */
    String getArticleTypeNameById(Long id);

    /**
     * 校验 id 对应的文章类型是否存在
     *
     * @param id 要校验的 id
     */
    void validArticleTypeIdExists(Long id);
}
