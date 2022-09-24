package com.jackwu.module.course.controller.admin.article.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 课程模块 - 文章 - 列表 responseVO
 *
 * @author jackwu
 */
@ApiModel("课程模块 - 文章 - 列表 responseVO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleListResponseVO extends ArticleBaseVO {

    /**
     * 编号
     */
    @ApiModelProperty(value = "文章编号", example = "1024")
    private Long id;

    /**
     * 分类名
     */
    @ApiModelProperty(value = "文章分类名", example = "新媒体")
    private String typeName;

    /**
     * 销量
     */
    @ApiModelProperty(value = "销量", example = "9999")
    private Integer sales;

    /**
     * 点赞数量
     */
    @ApiModelProperty(value = "点赞数量", example = "888888")
    private Integer likes;

    /**
     * 阅读次数
     */
    @ApiModelProperty(value = "阅读次数", example = "4356")
    private Integer readTime;

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", example = "true")
    private Boolean status;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", example = "时间戳格式")
    private LocalDateTime createTime;
}
