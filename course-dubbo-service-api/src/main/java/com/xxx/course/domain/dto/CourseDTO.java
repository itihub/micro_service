package com.xxx.course.domain.dto;

import com.xxx.thrift.user.domain.dto.TeacherDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Data
public class CourseDTO implements Serializable {

    private Integer id;

    private String title;

    private String description;

    private TeacherDTO teacherDTO;

}
