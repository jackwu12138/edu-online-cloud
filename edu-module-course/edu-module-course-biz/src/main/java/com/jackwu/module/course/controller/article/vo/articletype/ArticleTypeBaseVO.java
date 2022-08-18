package com.jackwu.module.course.controller.article.vo.articletype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程模块 - BaseVO
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
     * 姓名
     */
    private String name;

    /**
     * 显示顺序
     */
    private Integer sort;
}
