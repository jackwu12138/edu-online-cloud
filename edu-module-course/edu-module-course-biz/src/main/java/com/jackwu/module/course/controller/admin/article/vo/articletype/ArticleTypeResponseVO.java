package com.jackwu.module.course.controller.admin.article.vo.articletype;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 课程模块 - 文章类型 - 列表 responseVO
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleTypeResponseVO extends ArticleTypeBaseVO {

    /**
     * 文章类型编号
     */
    @ApiModelProperty(value = "文章类型编号", example = "1024")
    private Long id;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
}
