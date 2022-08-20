package com.jackwu.framework.file.core;

import cn.hutool.core.io.IoUtil;
import io.minio.*;

import java.io.ByteArrayInputStream;

/**
 * Minio 文件客户端
 *
 * @author jackwu
 */
public class MinioFileClient implements FileClient {

    private final MinioClient client;

    private final MinioFileClientProperties properties;

    public MinioFileClient(MinioFileClientProperties properties) {
        this.properties = properties;
        this.client = MinioClient
                .builder()
                .endpoint(properties.getEndpoint())
                .credentials(properties.getAccessKey(), properties.getAccessSecret())
                .build();
    }

    @Override
    public String upload(byte[] content, String path) throws Exception {
        PutObjectArgs objectArgs = PutObjectArgs
                .builder()
                .bucket(properties.getBucket())
                .object(path)
                .stream(new ByteArrayInputStream(content), content.length, -1)
                .build();
        client.putObject(objectArgs);
        // 拼接返回路径
        return properties.getDomain() + "/" + path;
    }

    @Override
    public void delete(String path) throws Exception {
        RemoveObjectArgs objectArgs = RemoveObjectArgs
                .builder()
                .bucket(properties.getBucket())
                .object(path)
                .build();
        client.removeObject(objectArgs);
    }

    @Override
    public byte[] getContent(String path) throws Exception {
        GetObjectArgs objectArgs = GetObjectArgs
                .builder()
                .bucket(properties.getBucket())
                .object(path)
                .build();
        GetObjectResponse response = client.getObject(objectArgs);
        return IoUtil.readBytes(response);
    }
}
