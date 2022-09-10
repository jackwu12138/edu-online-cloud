package com.jackwu.frameword.validation.core.annotation;

import com.jackwu.frameword.validation.core.validator.InEnumValidator;
import com.jackwu.framework.common.core.IntArrayValues;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.jackwu.frameword.validation.core.constant.ValidationMessageConstants.IN_ENUM_MESSAGE;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author jackwu
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {InEnumValidator.class})
public @interface InEnum {
    /**
     * @return 实现 Enum 接口的
     */
    Class<? extends IntArrayValues> value();

    String message() default IN_ENUM_MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
