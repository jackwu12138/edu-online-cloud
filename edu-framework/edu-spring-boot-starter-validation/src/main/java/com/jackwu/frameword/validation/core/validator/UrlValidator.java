package com.jackwu.frameword.validation.core.validator;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.jackwu.frameword.validation.core.annotation.URL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static cn.hutool.core.lang.Validator.isUrl;
import static com.jackwu.frameword.validation.core.constant.PatternConstants.URL_PATTERN;

/**
 * @author jackwu
 */
public class UrlValidator implements ConstraintValidator<URL, String> {

    @Override
    public void initialize(URL annotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StrUtil.isBlank(value)) {
            return true;
        }
        return ReUtil.isMatch(URL_PATTERN, value);
    }
}
