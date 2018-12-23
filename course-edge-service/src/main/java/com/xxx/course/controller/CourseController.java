package com.xxx.course.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xxx.course.domain.dto.CourseDTO;
import com.xxx.course.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Slf4j
@RestController
@RequestMapping("/course")
public class CourseController {

    @Reference
    private ICourseService courseService;

    @GetMapping("/courseList")
    public List<CourseDTO> courseList(){
        return courseService.courseList();
    }
}
