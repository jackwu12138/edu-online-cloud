package com.jackwu.framework.jackson.core.databind;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.jackwu.framework.jackson.core.annotation.Desensitization;
import com.jackwu.framework.jackson.core.enums.DesensitizationType;

import java.io.IOException;
import java.util.Objects;

/**
 * 数据脱敏的序列化规则
 * <p>
 * 会根据自定义的数据脱敏规则进行数据脱敏
 *
 * @author jackwu
 */
public class DesensitizationSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private DesensitizationType strategy;

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(strategy.getType().apply(value));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        Desensitization annotation = property.getAnnotation(Desensitization.class);
        if (ObjectUtil.isNotNull(annotation) && Objects.equals(String.class, property.getType().getRawClass())) {
            this.strategy = annotation.value();
            return this;
        }
        return prov.findValueSerializer(property.getType(), property);
    }
}
