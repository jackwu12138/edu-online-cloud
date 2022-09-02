package com.jackwu.module.course.controller.article.vo.article;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 课程模块 - 文章 - 更新 ResponseVO
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleUpdateResponseVO extends ArticleBaseVO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "文章编号", example = "1024")
    private Long id;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "创建时间", example = "true")
    private Boolean status;

    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容", example = "我言秋日胜春朝")
    private String content;
}
