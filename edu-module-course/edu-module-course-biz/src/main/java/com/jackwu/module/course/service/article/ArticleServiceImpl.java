package com.jackwu.module.course.service.article;

import com.jackwu.module.course.dal.mybatis.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jackwu
 */
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper baseMapper;
}
