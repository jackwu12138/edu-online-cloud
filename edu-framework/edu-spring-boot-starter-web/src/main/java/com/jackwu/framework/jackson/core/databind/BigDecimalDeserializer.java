package com.jackwu.framework.jackson.core.databind;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * BigDecimal 反序列化规则
 * <p>
 * 会将前端传递的 Double 反序列化为 BigDecimal
 *
 * @author jackwu
 */
public class BigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

    public static final BigDecimalDeserializer INSTANCE = new BigDecimalDeserializer();

    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return BigDecimal.valueOf(p.getValueAsDouble());
    }
}
