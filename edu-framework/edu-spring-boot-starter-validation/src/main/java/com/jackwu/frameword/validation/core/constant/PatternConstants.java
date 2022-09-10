package com.jackwu.frameword.validation.core.constant;

import java.util.regex.Pattern;

import static com.jackwu.frameword.validation.core.constant.RegexConstants.*;

/**
 * 常用的正则校验规则
 * 
 * @author jackwu
 */
public interface PatternConstants {

    /**
     * 邮箱(支持中文邮箱)
     */
    Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     * 移动电话
     */
    Pattern MOBILE_PATTERN = Pattern.compile(MOBILE_REGEX) ;

    /**
     * URL
     */
    Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

    /**
     * 中文名
     */
    Pattern CHINESE_NAME_PATTERN = Pattern.compile(CHINESE_NAME_REGEX);
}
