package com.jackwu.module.course.dal.dateobject.article;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jackwu.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jackwu
 */
@Data
@TableName(value = "edu_course_article")
@EqualsAndHashCode(callSuper = false)
public class ArticleDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面
     */
    private String cover;

    /**
     * 分类
     */
    private Long type;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 销量
     */
    private Integer sales;

    /**
     * 点赞数量
     */
    private Integer likes;

    /**
     * 阅读次数
     */
    private Integer readTime;

    /**
     * 是否启用
     */
    private Boolean status;

    /**
     * 文章内容
     */
    private String content;
}
