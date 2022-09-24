package com.jackwu.module.course.controller.admin.article.vo.articletype;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "文章类型名不能为空")
    @Length(min = 2, max = 14, message = "文章类型名长度在 2-14 之间")
    private String name;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", required = true, example = "0-99")
    @NotNull(message = "显示顺序不能为空")
    @Range(min = 0, max = 99, message = "显示顺序需要在 0-99 之间")
    private Integer sort;
}
