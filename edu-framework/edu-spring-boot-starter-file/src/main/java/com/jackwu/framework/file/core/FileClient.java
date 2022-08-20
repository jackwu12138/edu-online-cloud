package com.jackwu.framework.file.core;

/**
 * 抽象文件客户端, 定义了文件操作的相关接口
 *
 * @author jackwu
 */
public interface FileClient {

    /**
     * 上传文件
     *
     * @param content 文件流
     * @param path    相对路径
     * @return 完整路径，即 HTTP 访问地址
     * @throws Exception 上传文件失败时，抛出 Exception 异常
     */
    String upload(byte[] content, String path) throws Exception;

    /**
     * 删除文件
     *
     * @param path 要删除文件的相对路径
     * @throws Exception 删除文件失败时，抛出 Exception 异常
     */
    void delete(String path) throws Exception;

    /**
     * 获得文件的内容
     *
     * @param path 文件的相对路径
     * @return 文件的内容
     * @throws Exception 获得文件内容失败时, 抛出 Exception 错误
     */
    byte[] getContent(String path) throws Exception;
}
