package com.jackwu.module.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * edu-online-cloud 的课程模块启动类
 *
 * @author jackwu
 */
@SpringBootApplication(scanBasePackages = "com.jackwu.*")
public class EduCourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduCourseApplication.class, args);
    }
}
