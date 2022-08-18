package com.jackwu.module.course.service.article;

import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeCreateRequestVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeResponseVO;
import com.jackwu.module.course.controller.article.vo.articletype.ArticleTypeUpdateRequestVO;
import com.jackwu.module.course.convert.article.ArticleTypeConvert;
import com.jackwu.module.course.dal.dateobject.article.ArticleTypeDO;
import com.jackwu.module.course.dal.mybatis.article.ArticleTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        // todo 应该对合法性进行一个校验
        ArticleTypeDO entity = ArticleTypeConvert.INSTANCE.convert(requestVO);
        baseMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public void deleteArticleTypeById(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void updateArticleType(ArticleTypeUpdateRequestVO requestVO) {
        // todo 应该对合法性进行一个校验
        ArticleTypeDO entity = ArticleTypeConvert.INSTANCE.convert(requestVO);
        baseMapper.updateById(entity);
    }

    @Override
    public List<String> getSimpleArticleTypeList() {
        List<ArticleTypeDO> entities = baseMapper.selectList(null);
        // todo 这里的分页查询 name 应该在数据库层面去做
        return entities.stream().map(ArticleTypeDO::getName).collect(Collectors.toList());
    }

    @Override
    public List<ArticleTypeResponseVO> getArticleTypeList() {
        // todo 后续应该转换为分页数据
        List<ArticleTypeDO> articleTypeDos = baseMapper.selectList(null);
        return ArticleTypeConvert.INSTANCE.convertList(articleTypeDos);
    }
}
