package com.jackwu.module.system.rpc.config;

import com.jackwu.module.member.api.user.UserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * 系统模块的 rpc 相关配置
 *
 * @author jackwu
 */
@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = UserApi.class)
public class SystemRpcConfiguration {
}
