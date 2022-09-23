package com.jackwu.framework.jackson.core.databind;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.jackwu.framework.jackson.core.annotation.IpAddress;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Objects;

/**
 * 在数据库保存 ip 地址, 使用的是无符号整数
 * 使用无符号整数保存有以下几个优点:
 * <ol>
 *     <li>节省空间, 使用字符串需要15个字节(255.255.255.255), 使用 Long 则只需要八个字节</li>
 *     <li>方便范围查询</li>
 * </ol>
 *
 * @author jackwu
 */
@Slf4j
public class IpAddressSerializer extends JsonSerializer<Long> implements ContextualSerializer {

    @Override
    public void serialize(Long value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(NetUtil.longToIpv4(value));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        IpAddress annotation = property.getAnnotation(IpAddress.class);
        if (ObjectUtil.isNotNull(annotation) && Objects.equals(Long.class, property.getType().getRawClass())) {
            return this;
        }
        return prov.findValueSerializer(property.getType(), property);
    }
}
