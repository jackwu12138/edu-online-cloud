package com.jackwu.module.course.service.article;

import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.course.controller.admin.article.vo.article.ArticleCreateRequestVO;
import com.jackwu.module.course.controller.admin.article.vo.article.ArticleListResponseVO;
import com.jackwu.module.course.controller.admin.article.vo.article.ArticleUpdateRequestVO;
import com.jackwu.module.course.controller.admin.article.vo.article.ArticleUpdateResponseVO;

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
     * 获取文章分页列表
     *
     * @param param 分页参数
     * @return 文章分页列表
     */
    PageResult<ArticleListResponseVO> getArticlePageList(PageParam param);

    /**
     * 根据 id 获取文章信息
     *
     * @param id 文章编号
     * @return 文章信息
     */
    ArticleUpdateResponseVO getArticleInfo(Long id);

    /**
     * 根据文章类型 id 查询该文章类型下有多少文章
     *
     * @param id 文章类型编号
     * @return 文章数量
     */
    Long getArticleCountByTypeId(Long id);
}
