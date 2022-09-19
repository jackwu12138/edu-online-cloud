package com.jackwu.module.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * edu-online-cloud 的系统管理模块
 *
 * @author jackwu
 */
@SpringBootApplication(scanBasePackages = "com.jackwu.*")
public class EduSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduSystemApplication.class, args);
    }
}
