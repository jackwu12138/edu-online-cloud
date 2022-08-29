package com.jackwu.module.course.controller.article.vo.articletype;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 课程模块 - 文章类型 - 全部列表 responseVO
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
    @ApiModelProperty(value = "文章类型编号", required = true, example = "1024")
    private Long id;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", required = true)
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createTime;
}
