package com.jackwu.module.course.service.file;

/**
 * @author jackwu
 */
public interface FileService {

    /**
     * 创建文件, 并返回文件的访问路径
     *
     * @param filename 文件名
     * @param content  文件内容
     * @return 文件的访问路径
     * @throws Exception 上传文件时抛出的错误
     */
    String createFile(String filename, byte[] content) throws Exception;
}
