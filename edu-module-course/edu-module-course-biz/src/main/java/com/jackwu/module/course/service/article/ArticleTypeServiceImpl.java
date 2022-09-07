package com.jackwu.module.course.service.article;

import cn.hutool.core.util.ObjectUtil;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeResponseVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeSimpleResponseVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeUpdateRequestVO;
import com.jackwu.module.course.convert.article.ArticleTypeConvert;
import com.jackwu.module.course.dal.dateobject.article.ArticleTypeDO;
import com.jackwu.module.course.dal.mybatis.article.ArticleTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

import static com.jackwu.framework.common.util.exception.ServiceExceptionUtil.exception;
import static com.jackwu.module.course.constants.CourseErrorCodeConstants.*;

/**
 * 文章分类表的 service 实现类
 *
 * @author jackwu
 */
@Service
@RequiredArgsConstructor
public class ArticleTypeServiceImpl implements ArticleTypeService {

    private final ArticleTypeMapper baseMapper;

    private final ArticleTypeConvert mapperConvert;

    @Lazy
    @Resource
    private ArticleService articleService;

    @Override
    public Long createArticleType(ArticleTypeCreateRequestVO requestVO) {
        validateNameDuplicate(requestVO.getName(), null);
        ArticleTypeDO entity = mapperConvert.convert(requestVO);
        // 默认启用文章类型
        entity.setStatus(true);
        baseMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void deleteArticleTypeById(Long id) {
        // 校验文章类型是否存在
        this.validArticleTypeIdExists(id);
        // 校验该类型是否还存在对应的文章
        this.checkArticleCount(id);

        baseMapper.deleteById(id);
    }

    @Override
    public void updateArticleType(ArticleTypeUpdateRequestVO requestVO) {
        // 验证要修改的 id 是否存在
        validArticleTypeIdExists(requestVO.getId());
        // 验证修改后是否会发生名字的冲突
        validateNameDuplicate(requestVO.getName(), requestVO.getId());
        ArticleTypeDO entity = mapperConvert.convert(requestVO);
        baseMapper.updateById(entity);
    }

    @Override
    public List<ArticleTypeSimpleResponseVO> getSimpleArticleTypeList() {
        List<ArticleTypeDO> entities = baseMapper.selectList(ArticleTypeDO::getStatus, true);
        entities.sort(Comparator.comparingInt(ArticleTypeDO::getSort));

        return mapperConvert.convertList1(entities);
    }

    @Override
    public List<ArticleTypeResponseVO> getArticleTypeList() {
        List<ArticleTypeDO> articleTypeDos = baseMapper.selectList(null);
        return mapperConvert.convertList(articleTypeDos);
    }

    @Override
    public String getArticleTypeNameById(Long id) {
        ArticleTypeDO typeDO = baseMapper.selectById(id);
        if (ObjectUtil.isNull(typeDO)) {
            return null;
        }
        return typeDO.getName();
    }

    @Override
    public void validArticleTypeIdExists(Long id) {
        ArticleTypeDO entity = baseMapper.selectById(id);
        if (ObjectUtil.isNull(entity)) {
            throw exception(COURSE_ERROR_ARTICLE_TYPE_NOT_FOUND);
        }
    }

    /**
     * 验证该文章类型名是否已经存在
     *
     * @param name 要验证的文章类型名
     * @param id   要验证的 id
     */
    public void validateNameDuplicate(String name, Long id) {
        ArticleTypeDO entity = this.baseMapper.selectOne(ArticleTypeDO::getName, name);
        if (ObjectUtil.isNull(entity)) {
            return;
        }
        if (ObjectUtil.isNull(id)) {
            throw exception(COURSE_ERROR_ARTICLE_TYPE_ALREADY_EXISTS, name);
        }
        if (ObjectUtil.notEqual(id, entity.getId())) {
            throw exception(COURSE_ERROR_ARTICLE_TYPE_ALREADY_EXISTS, name);
        }
    }

    /**
     * 验证是否该类型下还有对应的文章
     *
     * @param id 文章类型编号
     */
    private void checkArticleCount(Long id) {
        Long articleCountByTypeId = articleService.getArticleCountByTypeId(id);
        // 如果对应的文章数不为 0
        if (!articleCountByTypeId.equals(0L)) {
            throw exception(COURSE_ERROR_ARTICLE_TYPE_HAS_CHILDREN);
        }
    }
}
