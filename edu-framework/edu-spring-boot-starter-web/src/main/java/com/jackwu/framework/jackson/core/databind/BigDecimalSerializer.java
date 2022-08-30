package com.jackwu.framework.jackson.core.databind;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author jackwu
 */
public class BigDecimalSerializer extends JsonSerializer<BigDecimal> {

    public static final BigDecimalSerializer INSTANCE = new BigDecimalSerializer();

    private static final DecimalFormat FORMATTER = new DecimalFormat("0.00");

    private static final String ZERO_FORMAT_STRING = "0.00";

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (ObjectUtil.isNotNull(value)) {
            gen.writeString(FORMATTER.format(value));
            return;
        }
        gen.writeString(ZERO_FORMAT_STRING);
    }
}
