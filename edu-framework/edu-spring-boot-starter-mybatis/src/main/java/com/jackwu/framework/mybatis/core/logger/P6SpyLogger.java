package com.jackwu.framework.mybatis.core.logger;

import cn.hutool.core.util.StrUtil;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * P6spy 的自定义日志打印类
 *
 * @author jackwu
 */
public class P6SpyLogger implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category,
            String prepared, String sql, String s4) {
        if (sql.length() == 0) {
            return StrUtil.EMPTY;
        }
        return StrUtil.format("{} | connection--{} | [{}]ms\n{};\n{}",
                category, connectionId, elapsed, sql, StrUtil.repeat("-", 180));
    }
}
