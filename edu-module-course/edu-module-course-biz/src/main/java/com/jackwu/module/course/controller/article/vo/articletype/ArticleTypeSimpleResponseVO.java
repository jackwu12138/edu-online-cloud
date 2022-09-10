package com.jackwu.module.course.controller.article.vo.articletype;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTypeSimpleResponseVO {

    /**
     * 文章类型编号
     */
    @ApiModelProperty(value = "文章类型编号", example = "1024")
    private Long id;

    /**
     * 文章类型名
     */
    @ApiModelProperty(value = "文章类型名", example = "name")
    private String name;
}
