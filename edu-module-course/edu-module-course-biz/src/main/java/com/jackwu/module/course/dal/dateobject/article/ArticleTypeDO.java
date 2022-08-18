package com.jackwu.module.course.dal.dateobject.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jackwu.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章分类表的实体类
 *
 * @author jackwu
 */
@Data
@TableName("course_article_type")
@EqualsAndHashCode(callSuper = true)
public class ArticleTypeDO extends BaseDO {

    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 分类名
     */
    private String name;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 是否启用
     */
    private Boolean status;
}
