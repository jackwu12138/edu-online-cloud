package com.jackwu.module.course.controller.article.vo.article;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 课程模块 - 文章 - 更新 RequestVO
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleUpdateRequestVO extends ArticleBaseVO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "文章编号", required = true, example = "1024")
    @NotNull(message = "文章编号不能为空")
    private Long id;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", required = true, example = "true")
    @NotNull(message = "请选择是否启用")
    private Boolean status;

    /**
     * 文章内容
     */
    @ApiModelProperty(value = "文章内容", example = "我言秋日胜春朝")
    @NotNull(message = "文章内容不能为空")
    private String content;
}
