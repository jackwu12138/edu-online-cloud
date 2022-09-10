package com.jackwu.module.course.controller.article.vo.article;

import com.jackwu.frameword.validation.core.annotation.URL;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "标题不能为空")
    @Length(min = 6, max = 128, message = "标题长度在 6-128 之间")
    private String title;

    /**
     * 封面
     */
    @ApiModelProperty(value = "文章封面", required = true, example = "https://xxxx/xxxx.png")
    @NotNull(message = "文章封面不能为空")
    @URL
    private String cover;

    /**
     * 分类 id
     */
    @ApiModelProperty(value = "文章分类编号", required = true, example = "1024")
    @NotNull(message = "文章分类编号不能为空")
    private Long type;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格", required = true, example = "9.00")
    @NotNull(message = "价格不能为空")
    @DecimalMin(value = "0.00", message = "价格不能为负")
    private BigDecimal price;
}
