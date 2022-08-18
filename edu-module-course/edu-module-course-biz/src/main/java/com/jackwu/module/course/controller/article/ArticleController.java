package com.jackwu.module.course.controller.article;

import com.jackwu.module.course.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 课程模块 - 文章
 *
 * @author jackwu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/course/article")
public class ArticleController {

    private final ArticleService service;
}
