package com.jackwu.module.course.controller.admin.article.vo.articletype;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
    @NotNull(message = "文章类型编号不能为空")
    private Long id;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", required = true)
    @NotNull(message = "请选择是否启用")
    private Boolean status;
}
