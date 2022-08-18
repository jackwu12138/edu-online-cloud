package com.jackwu.module.course.controller.article;

import com.jackwu.module.course.service.article.ArticleService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jackwu
 */
@Data
@RestController
@RequestMapping("/course/article")
public class ArticleController {

    private final ArticleService service;
}
