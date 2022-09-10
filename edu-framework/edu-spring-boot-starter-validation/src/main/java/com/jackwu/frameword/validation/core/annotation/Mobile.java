package com.jackwu.frameword.validation.core.annotation;

import com.jackwu.frameword.validation.core.validator.MobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.jackwu.frameword.validation.core.constant.ValidationMessageConstants.MOBILE_NUMBER_VERIFICATION_FAILED;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 自定义手机号的验证注解
 *
 * @author jackwu
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {MobileValidator.class})
public @interface Mobile {

    String message() default MOBILE_NUMBER_VERIFICATION_FAILED;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
