package com.jackwu.frameword.validation.core.annotation;

import com.jackwu.frameword.validation.core.validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.jackwu.frameword.validation.core.constant.ValidationMessageConstants.EMAIL_VERIFICATION_FAILED;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author jackwu
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {EmailValidator.class})
public @interface Email {

    String message() default EMAIL_VERIFICATION_FAILED;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
