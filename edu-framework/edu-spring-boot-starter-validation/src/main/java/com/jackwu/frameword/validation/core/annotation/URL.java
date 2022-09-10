package com.jackwu.frameword.validation.core.annotation;

import com.jackwu.frameword.validation.core.validator.MobileValidator;
import com.jackwu.frameword.validation.core.validator.UrlValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.jackwu.frameword.validation.core.constant.ValidationMessageConstants.MOBILE_NUMBER_VERIFICATION_FAILED;
import static com.jackwu.frameword.validation.core.constant.ValidationMessageConstants.URL_VERIFICATION_FAILED;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义 Url 的数据校验注解
 *
 * @author jackwu
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {UrlValidator.class})
public @interface URL {
    String message() default URL_VERIFICATION_FAILED;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
