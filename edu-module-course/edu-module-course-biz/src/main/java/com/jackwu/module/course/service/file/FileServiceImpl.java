package com.jackwu.module.course.service.file;

import cn.hutool.core.lang.UUID;
import com.jackwu.framework.file.core.FileClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        String newFilename = UUID.fastUUID().toString();
        if (index != -1) {
            newFilename += filename.substring(index);
        }
        return fileClient.upload(content, newFilename);
    }
}
