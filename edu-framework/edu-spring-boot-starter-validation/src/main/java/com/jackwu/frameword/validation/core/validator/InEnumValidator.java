package com.jackwu.frameword.validation.core.validator;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.jackwu.frameword.validation.core.annotation.InEnum;
import com.jackwu.framework.common.core.IntArrayValues;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import static com.jackwu.frameword.validation.core.constant.ValidationMessageConstants.IN_ENUM_MESSAGE;

/**
 * @author jackwu
 */
public class InEnumValidator implements ConstraintValidator<InEnum, Integer> {

    private Set<Integer> values;

    @Override
    public void initialize(com.jackwu.frameword.validation.core.annotation.InEnum annotation) {
        IntArrayValues[] values = annotation.value().getEnumConstants();
        this.values = ArrayUtil.isEmpty(values) ?
                Collections.emptySet() :
                Arrays.stream(values[0].toArray()).boxed().collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (ObjectUtil.isNull(value)) {
            return true;
        }
        if (values.contains(value)) {
            return true;
        }
        // 禁用默认的 message 的值
        context.disableDefaultConstraintViolation();
        // 修改默认的值
        context.buildConstraintViolationWithTemplate(StrUtil.format(IN_ENUM_MESSAGE, values)).addConstraintViolation();

        return false;
    }
}
