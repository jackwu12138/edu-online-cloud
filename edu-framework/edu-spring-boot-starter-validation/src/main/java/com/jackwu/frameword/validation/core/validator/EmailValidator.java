package com.jackwu.frameword.validation.core.validator;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import com.jackwu.frameword.validation.core.annotation.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.jackwu.frameword.validation.core.constant.PatternConstants.EMAIL_PATTERN;

/**
 * @author jackwu
 */
public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(com.jackwu.frameword.validation.core.annotation.Email annotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StrUtil.isBlank(value)) {
            return true;
        }
        return ReUtil.isMatch(EMAIL_PATTERN, value);
    }
}
