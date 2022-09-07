package com.jackwu.module.course.service.article;

import cn.hutool.core.util.ObjectUtil;
import com.jackwu.framework.common.pojo.PageParam;
import com.jackwu.framework.common.pojo.PageResult;
import com.jackwu.module.course.controller.article.vo.article.ArticleCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleListResponseVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleUpdateRequestVO;
import com.jackwu.module.course.controller.article.vo.article.ArticleUpdateResponseVO;
import com.jackwu.module.course.convert.article.ArticleConvert;
import com.jackwu.module.course.dal.dateobject.article.ArticleDO;
import com.jackwu.module.course.dal.mybatis.article.ArticleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jackwu.framework.common.util.exception.ServiceExceptionUtil.exception;
import static com.jackwu.module.course.constants.CourseErrorCodeConstants.COURSE_ERROR_ARTICLE_NOT_FOUND;

/**
 * 文章表的 service 实现类
 *
 * @author jackwu
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper baseMapper;

    private final ArticleConvert mapperConvert;

    private final ArticleTypeService articleTypeService;

    @Override
    public Long createArticle(ArticleCreateRequestVO vo) {
        // 校验文章类型是否存在
        articleTypeService.validArticleTypeIdExists(vo.getType());
        // 类型转换
        ArticleDO ado = mapperConvert.convert(vo);
        // 为要插入的数据设置默认值
        this.setDefaultProperties(ado);
        // 执行插入操作
        baseMapper.insert(ado);
        return ado.getId();
    }

    @Override
    public void deleteArticle(Long id) {
        // 校验 id 是否存在
        this.validateArticleExists(id);
        // 执行删除操作
        baseMapper.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleUpdateRequestVO vo) {
        // 校验 id 是否存在
        this.validateArticleExists(vo.getId());
        // 校验分类 id 是否存在
        articleTypeService.validArticleTypeIdExists(vo.getType());

        // 执行更新操作
        ArticleDO entity = mapperConvert.convert(vo);
        baseMapper.updateById(entity);
    }

    @Override
    public PageResult<ArticleListResponseVO> getArticlePageList(PageParam param) {
        PageResult<ArticleDO> articleDos = baseMapper.selectPage(param,null);
        // 查出的所有文章信息转换为 vo
        PageResult<ArticleListResponseVO> vos = mapperConvert.convertPage(articleDos);
        // 根据 typeId 去查询相对应的文章类型名
        // todo 循环查库, 后面记得做缓存
        vos.getData().forEach(vo -> vo.setTypeName(articleTypeService.getArticleTypeNameById(vo.getType())));

        return vos;
    }

    @Override
    public ArticleUpdateResponseVO getArticleInfo(Long id) {
        ArticleDO aDo = baseMapper.selectById(id);
        if (ObjectUtil.isNull(aDo)) {
            throw exception(COURSE_ERROR_ARTICLE_NOT_FOUND);
        }
        return mapperConvert.convert(aDo);
    }

    @Override
    public Long getArticleCountByTypeId(Long typeId) {
        return baseMapper.selectCount(ArticleDO::getType, typeId);
    }

    /**
     * 验证该编号对应的文章信息是否存在
     *
     * @param id id
     */
    private void validateArticleExists(Long id) {
        ArticleDO entity = baseMapper.selectById(id);
        if (ObjectUtil.isNull(entity)) {
            throw exception(COURSE_ERROR_ARTICLE_NOT_FOUND);
        }
    }

    private void setDefaultProperties(ArticleDO ado) {
        // 设置点赞数
        ado.setLikes(0);
        // 设置销售量
        ado.setSales(0);
        // 默认启用
        ado.setStatus(true);
        // 阅读量
        ado.setReadTime(0);
    }
}
