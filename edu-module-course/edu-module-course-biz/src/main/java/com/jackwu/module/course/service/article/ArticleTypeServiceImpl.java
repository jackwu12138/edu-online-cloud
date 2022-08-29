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
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.jackwu.framework.common.util.exception.ServiceExceptionUtil.exception;
import static com.jackwu.module.course.constants.CourseErrorCodeConstants.COURSE_ERROR_ARTICLE_TYPE_ALREADY_EXISTS;
import static com.jackwu.module.course.constants.CourseErrorCodeConstants.COURSE_ERROR_ARTICLE_TYPE_NOT_FOUND;

/**
 * 文章分类表的 service 实现类
 *
 * @author jackwu
 */
@Service
@RequiredArgsConstructor
public class ArticleTypeServiceImpl implements ArticleTypeService {

    private final ArticleTypeMapper baseMapper;

    @Override
    public Long createArticleType(ArticleTypeCreateRequestVO requestVO) {
        validateNameDuplicate(requestVO.getName(), null);
        ArticleTypeDO entity = ArticleTypeConvert.INSTANCE.convert(requestVO);
        // 默认启用文章类型
        entity.setStatus(true);
        baseMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void deleteArticleTypeById(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void updateArticleType(ArticleTypeUpdateRequestVO requestVO) {
        // 验证要修改的 id 是否存在
        validateNameDuplicate(requestVO.getId());
        // 验证修改后是否会发生名字的冲突
        validateNameDuplicate(requestVO.getName(), requestVO.getId());
        ArticleTypeDO entity = ArticleTypeConvert.INSTANCE.convert(requestVO);
        baseMapper.updateById(entity);
    }

    @Override
    public List<ArticleTypeSimpleResponseVO> getSimpleArticleTypeList() {
        List<ArticleTypeDO> entities = baseMapper.selectList(null);
        entities.sort(Comparator.comparingInt(ArticleTypeDO::getSort));

        return ArticleTypeConvert.INSTANCE.convertList1(entities);
    }

    @Override
    public List<ArticleTypeResponseVO> getArticleTypeList() {
        // todo 后续应该转换为分页数据
        List<ArticleTypeDO> articleTypeDos = baseMapper.selectList(null);
        return ArticleTypeConvert.INSTANCE.convertList(articleTypeDos);
    }

    /**
     * 验证该文章类型名是否已经存在
     *
     * @param name 要验证的文章类型名
     * @param id   要验证的 id
     */
    public void validateNameDuplicate(String name, Long id) {
        ArticleTypeDO entity = baseMapper.getArticleTypeByName(name);
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
     * 验证该字典类型 id 是否存在
     *
     * @param id 要查询的字典类型 id
     */
    public void validateNameDuplicate(Long id) {
        ArticleTypeDO entity = baseMapper.selectById(id);
        if (ObjectUtil.isNull(entity)) {
            throw exception(COURSE_ERROR_ARTICLE_TYPE_NOT_FOUND);
        }
    }
}
