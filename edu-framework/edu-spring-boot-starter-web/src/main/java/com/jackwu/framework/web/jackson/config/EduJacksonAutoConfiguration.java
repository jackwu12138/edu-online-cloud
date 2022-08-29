package com.jackwu.framework.web.jackson.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jackwu.framework.common.util.json.JsonUtil;
import com.jackwu.framework.web.jackson.core.databind.LocalDateTimeDeserializer;
import com.jackwu.framework.web.jackson.core.databind.LocalDateTimeSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * jackson 配置类
 *
 * @author jackwu
 */
@Slf4j
@Configuration
public class EduJacksonAutoConfiguration {

    /**
     * 1. Long类型序列化规则，数值超过2^53-1，在JS会出现精度丢失问题，因此Long自动序列化为字符串类型
     * <p>
     * 2. LocalDateTime序列化、反序列化规则
     */
    @Bean
    public BeanPostProcessor objectMapperBeanPostProcessor() {
        log.debug("Bean 'objectMapperBeanPostProcessor' configured for use");
        return new BeanPostProcessor() {
            @Override
            @SuppressWarnings("NullableProblems")
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (!(bean instanceof ObjectMapper)) {
                    return bean;
                }
                ObjectMapper objectMapper = (ObjectMapper) bean;
                SimpleModule simpleModule = new SimpleModule();

                simpleModule
                        .addSerializer(Long.class, ToStringSerializer.instance)
                        .addSerializer(Long.TYPE, ToStringSerializer.instance)
                        .addSerializer(LocalDateTime.class, LocalDateTimeSerializer.INSTANCE)
                        .addDeserializer(LocalDateTime.class, LocalDateTimeDeserializer.INSTANCE);

                objectMapper.registerModules(simpleModule);

                JsonUtil.init(objectMapper);
                return bean;
            }
        };
    }
}
