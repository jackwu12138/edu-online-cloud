package com.jackwu.framework.file.core;

import lombok.Data;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

/**
 * Minio 的文件客户端的相关配置
 *
 * @author jackwu
 */
@Data
@ConfigurationProperties(prefix = "edu.file")
public class MinioFileClientProperties {

    /**
     * 结点的地址
     */
    @NotNull(message = "endpoint 不能为空")
    private String endpoint;

    /**
     * 访问域名, 后期通过 Nginx 配置的访问域名
     */
    @URL(message = "domain 必须是 URL 格式")
    private String domain;

    /**
     * 存储 Bucket
     */
    @NotNull(message = "bucket 不能为空")
    private String bucket;

    /**
     * 访问 accessKey
     */
    @NotNull(message = "accessKey 不能为空")
    private String accessKey;
    /**
     * 访问 Secret
     */
    @NotNull(message = "accessSecret 不能为空")
    private String accessSecret;
}
