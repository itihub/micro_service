package com.xxx.course.mapper;

import com.xxx.course.domain.dto.CourseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Mapper
public interface CourseMapper {

    @Select("SELECT * FROM pe_course")
    List<CourseDTO> listCourse();

    @Select("SELECT user_id FROM pr_user_course WHERE course_id = #{courseId}")
    Integer getCourseTeacher(@Param("courseId") int courseId);
}
