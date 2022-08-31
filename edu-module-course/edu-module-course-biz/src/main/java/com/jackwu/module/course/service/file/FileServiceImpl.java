package com.jackwu.module.course.service.file;

import cn.hutool.core.lang.UUID;
import com.jackwu.framework.file.core.FileClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author jackwu
 */
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileClient fileClient;

    @Override
    public String createFile(String filename, byte[] content) throws Exception {
        int index = filename.lastIndexOf(".");
        // 获取当前日期
        String dateString = LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        // 拼接文件名
        String newFilename = dateString + "/" + UUID.fastUUID();
        // 设置文件后缀名
        if (index != -1) {
            newFilename += filename.substring(index);
        }
        return fileClient.upload(content, newFilename);
    }
}
