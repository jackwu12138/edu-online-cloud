package com.jackwu.module.course.service.article;

import com.jackwu.module.course.controller.article.vo.article.ArticleCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleListResponseVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleUpdateRequestVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleUpdateResponseVO;

import java.util.List;

/**
 * 文章表的 service 接口
 *
 * @author jackwu
 */
public interface ArticleService {

    /**
     * 创建文章
     *
     * @param vo 文章信息
     * @return 创建好的文章编号
     */
    Long createArticle(ArticleCreateRequestVO vo);

    /**
     * 根据删除文章
     *
     * @param id 要删除的文章编号
     */
    void deleteArticle(Long id);

    /**
     * 根据 id 更新文章信息
     *
     * @param vo 要更新的文章信息
     */
    void updateArticle(ArticleUpdateRequestVO vo);

    /**
     * 获取全部的文章列表
     *
     * @return 文章列表
     */
    List<ArticleListResponseVO> getArticleList();

    /**
     * 根据 id 获取文章信息
     *
     * @param id 文章编号
     * @return 文章信息
     */
    ArticleUpdateResponseVO getArticleInfo(Long id);
}
