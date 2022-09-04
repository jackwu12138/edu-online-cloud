package com.jackwu.module.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * edu-online-cloud 的用户模块启动类
 *
 * @author jackwu
 */
@SpringBootApplication(scanBasePackages = "com.jackwu.*")
public class EduMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduMemberApplication.class, args);
    }
}
