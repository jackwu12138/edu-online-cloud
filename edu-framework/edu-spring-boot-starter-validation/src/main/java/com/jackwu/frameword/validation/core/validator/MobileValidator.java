package com.jackwu.frameword.validation.core.validator;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.jackwu.frameword.validation.core.constant.PatternConstants.MOBILE_PATTERN;

/**
 * 自定义手机号的验证
 *
 * @author jackwu
 */
public class MobileValidator implements ConstraintValidator<com.jackwu.frameword.validation.core.annotation.Mobile, String> {

    @Override
    public void initialize(com.jackwu.frameword.validation.core.annotation.Mobile annotation) {}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StrUtil.isBlank(value)) {
            return true;
        }
        return ReUtil.isMatch(MOBILE_PATTERN, value);
    }
}
