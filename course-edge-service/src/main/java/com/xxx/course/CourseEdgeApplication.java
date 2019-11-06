package com.xxx.course;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@SpringBootApplication
@EnableDubboConfiguration
public class CourseEdgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseEdgeApplication.class, args);
    }
}
