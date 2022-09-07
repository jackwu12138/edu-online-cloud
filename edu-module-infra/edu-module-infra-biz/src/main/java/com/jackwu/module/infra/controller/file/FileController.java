package com.jackwu.module.infra.controller.file;

import cn.hutool.core.io.IoUtil;
import com.jackwu.framework.common.pojo.CommonResult;
import com.jackwu.module.infra.service.file.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.jackwu.framework.common.pojo.CommonResult.success;

/**
 * @author jackwu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/infra/file")
public class FileController {

    private final FileService fileService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public CommonResult<String> uploadFile(@RequestPart("file") MultipartFile file) throws Exception {
        return success(fileService.createFile(file.getOriginalFilename(), IoUtil.readBytes(file.getInputStream())));
    }
}
