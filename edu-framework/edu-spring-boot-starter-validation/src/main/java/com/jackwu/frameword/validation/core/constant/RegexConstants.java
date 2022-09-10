package com.jackwu.frameword.validation.core.constant;

/**
 * 常用的正则表达式, 更多正则见:
 * <a href="https://any86.github.io/any-rule/">https://any86.github.io/any-rule/</a>
 *
 * @author jackwu
 */
public interface RegexConstants {

    /**
     * 邮箱(支持中文邮箱)
     */
    String EMAIL_REGEX = "[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";

    /**
     * 移动电话
     */
    String MOBILE_REGEX = "(?:(?:\\+|00)86)?1(?:(?:3[\\d])|(?:4[5-79])|(?:5[0-35-9])|(?:6[5-7])|(?:7[0-8])|(?:8[\\d])|(?:9[189]))\\d{8}";

    /**
     * URL
     */
    String URL_REGEX = "(((ht|f)tps?):\\/\\/)?([^!@#$%^&*?.\\s-]([^!@#$%^&*?.\\s]{0,63}[^!@#$%^&*?.\\s])?\\.)+[a-z]{2,6}\\/?";

    /**
     * 中文名
     */
    String CHINESE_NAME_REGEX = "(?:[\\u4e00-\\u9fa5·]{2,16})";
}
