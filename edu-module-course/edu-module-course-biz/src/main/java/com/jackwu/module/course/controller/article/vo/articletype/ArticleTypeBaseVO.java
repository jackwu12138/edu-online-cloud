package com.jackwu.module.course.controller.article.vo.articletype;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程模块 - 文章类型 - BaseVO
 * <p>
 * 提供通用字段给子 VO 使用
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTypeBaseVO {

    /**
     * 文章类型名
     */
    @ApiModelProperty(value = "文章类型名", required = true, example = "name")
    private String name;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", required = true, example = "0-99")
    private Integer sort;
}
