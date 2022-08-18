package com.jackwu.module.course.controller.article.vo.articletype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 课程模块 - 文章分类 responseVO
 *
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleTypeResponseVO extends ArticleTypeBaseVO {

    /**
     * 编号
     */
    private Long id;

    /**
     * 是否启用
     */
    private Boolean status;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
