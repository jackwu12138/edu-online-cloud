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

    /**
     * 当 BigDecimal 属性为 null 时, 默认格式化成 ZERO_FORMAT_STRING
     */
    private static final String ZERO_FORMAT_STRING = "0.00";

    /**
     * 日期格式化器
     * <p>
     * 因为{@link DecimalFormat} 不是线程安全的, 所以这里使用{@link ThreadLocal} 重新包装了一下
     */
    private static final ThreadLocal<DecimalFormat> FORMATTER =
            ThreadLocal.withInitial(() -> new DecimalFormat("0.00"));

    @Override
    public void serialize(BigDecimal value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (ObjectUtil.isNotNull(value)) {
            gen.writeString(FORMATTER.get().format(value));
            return;
        }
        gen.writeString(ZERO_FORMAT_STRING);
    }
}
