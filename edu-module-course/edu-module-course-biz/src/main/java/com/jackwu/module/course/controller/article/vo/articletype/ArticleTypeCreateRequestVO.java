package com.jackwu.module.course.controller.article.vo.articletype;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 课程模块 - 文章类型 - 创建文章类型 Request VO
 *
 * @author jackwu
 */
@ApiModel("课程模块 - 文章类型 - 创建文章类型 Request VO")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleTypeCreateRequestVO extends ArticleTypeBaseVO {}
