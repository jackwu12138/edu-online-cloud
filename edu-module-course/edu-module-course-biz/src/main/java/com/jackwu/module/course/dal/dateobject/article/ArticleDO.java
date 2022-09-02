package com.jackwu.module.course.dal.dateobject.article;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jackwu.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 文章表的实体类
 *
 * @author jackwu
 */
@Data
@TableName(value = "course_article")
@EqualsAndHashCode(callSuper = true)
public class ArticleDO extends BaseDO {

    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
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
     * 分类 id {@link ArticleTypeDO#getId()}
     */
    private Long type;

    /**
     * 价格
     */
    private BigDecimal price;

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
