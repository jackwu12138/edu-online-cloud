package com.jackwu.module.course.constants;

import com.jackwu.framework.common.exception.ErrorCode;

/**
 * 课程模块的错误码枚举类
 *
 * @author jackwu
 */
public interface CourseErrorCodeConstants {

    // -------------------- 文章相关 [ A3000 - A3099 ] -------------------- //

    ErrorCode COURSE_ERROR_ARTICLE_TYPE_NOT_FOUND = new ErrorCode("A3000", "文章类型不存在");
    ErrorCode COURSE_ERROR_ARTICLE_TYPE_ALREADY_EXISTS = new ErrorCode("A3001", "文章类型[{}]已经存在");
    ErrorCode COURSE_ERROR_ARTICLE_TYPE_HAS_CHILDREN = new ErrorCode("A3002", "无法删除, 该文章类型还有文章数据");

    ErrorCode COURSE_ERROR_ARTICLE_NOT_FOUND = new ErrorCode("A3010", "文章不存在");
}
