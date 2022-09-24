package com.jackwu.module.course.controller.admin.article.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 课程模块 - 文章 - 创建文章 Request VO
 *
 * @author jackwu
 */
@ApiModel("课程模块 - 文章 - 创建文章 Request VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleCreateRequestVO extends ArticleBaseVO {

    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容", required = true, example = "自古逢秋悲寂寥")
    @NotNull(message = "文章内容不能为空")
    private String content;
}
