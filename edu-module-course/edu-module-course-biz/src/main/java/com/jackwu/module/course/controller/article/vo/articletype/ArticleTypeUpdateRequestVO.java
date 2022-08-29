package com.jackwu.module.course.controller.article.vo.articletype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 课程模块 - 文章类型 - 更新文章类型 Request VO
 *
 * @author jackwu
 */
@ApiModel("课程模块 - 文章类型 - 更新文章类型 Request VO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleTypeUpdateRequestVO extends ArticleTypeBaseVO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "文章类型编号", required = true, example = "1024")
    private Long id;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", required = true)
    private Boolean status;
}
