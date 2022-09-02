package com.jackwu.module.course.controller.article.vo.article;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 课程模块 - 文章 - BaseVO
 * <p>
 * 提供通用字段给子 VO 使用
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleBaseVO {

    /**
     * 标题
     */
    @ApiModelProperty(value = "文章标题", required = true, example = "title")
    private String title;

    /**
     * 封面
     */
    @ApiModelProperty(value = "文章封面", required = true, example = "https://xxxx/xxxx.png")
    private String cover;

    /**
     * 分类 id
     */
    @ApiModelProperty(value = "文章分类编号", required = true, example = "1024")
    private Long type;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格", required = true, example = "9.00")
    private BigDecimal price;
}
