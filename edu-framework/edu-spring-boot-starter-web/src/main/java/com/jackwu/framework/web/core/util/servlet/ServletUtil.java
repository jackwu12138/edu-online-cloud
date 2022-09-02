package com.jackwu.framework.web.core.util.servlet;

import cn.hutool.core.util.StrUtil;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;

/**
 * @author jackwu
 */
public class ServletUtil {

    /**
     * 判断当前请求是否为 json 请求
     *
     * @param request 请求
     */
    public static boolean isJsonRequest(ServletRequest request) {
        return StrUtil.startWithIgnoreCase(request.getContentType(), MediaType.APPLICATION_JSON_VALUE);
    }
}
