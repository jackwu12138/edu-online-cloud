package com.jackwu.framework.jackson.core.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jackwu.framework.jackson.core.databind.DesensitizationSerializer;
import com.jackwu.framework.jackson.core.enums.DesensitizationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据脱敏的注解
 * <p>
 * 注意必须配置脱敏策略, 不配置的话默认为空
 *
 * @author jackwu
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizationSerializer.class)
public @interface Desensitization {

    DesensitizationType value() default DesensitizationType.NONE;
}
