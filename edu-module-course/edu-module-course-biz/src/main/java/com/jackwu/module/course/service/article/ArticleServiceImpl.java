package com.jackwu.module.course.service.article;

import com.jackwu.module.course.dal.mybatis.article.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 文章表的 service 实现类
 *
 * @author jackwu
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper baseMapper;
}
