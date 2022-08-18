package com.jackwu.module.course.constants;

import com.jackwu.framework.common.exception.ErrorCode;

/**
 * 课程模块的错误码枚举类
 *
 * @author jackwu
 */
public interface CourseErrorCodeConstants {

    // -------------------- 文章相关 [ A1000 - A1099 ] -------------------- //

    ErrorCode COURSE_ERROR_ARTICLE_TYPE_NOT_FOUND = new ErrorCode("A1000", "文章类型不存在");
    ErrorCode COURSE_ERROR_ARTICLE_TYPE_ALREADY_EXISTS = new ErrorCode("A1001", "文章类型[{}]已经存在");
}
