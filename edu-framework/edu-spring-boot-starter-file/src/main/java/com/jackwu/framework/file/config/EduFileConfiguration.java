package com.jackwu.framework.file.config;

import com.jackwu.framework.file.core.FileClient;
import com.jackwu.framework.file.core.MinioFileClient;
import com.jackwu.framework.file.core.MinioFileClientProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jackwu
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MinioFileClientProperties.class)
public class EduFileConfiguration {

    private final MinioFileClientProperties properties;

    @Bean
    public FileClient getFileClient() {
        log.debug("Bean 'FileClient' configured for use");
        return new MinioFileClient(properties);
    }
}
