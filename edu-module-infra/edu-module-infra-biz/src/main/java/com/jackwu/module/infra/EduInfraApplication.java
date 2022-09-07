package com.jackwu.module.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * edu-online-cloud 的基础设施模块
 *
 * @author jackwu
 */
@SpringBootApplication(scanBasePackages = "com.jackwu.*")
public class EduInfraApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduInfraApplication.class, args);
    }
}
