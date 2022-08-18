package com.jackwu.module.course.controller.article.vo.articletype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author jackwu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleTypeUpdateRequestVO extends ArticleTypeBaseVO {

    /**
     * 编号
     */
    private Long id;

    /**
     * 是否启用
     */
    private Boolean status;
}
