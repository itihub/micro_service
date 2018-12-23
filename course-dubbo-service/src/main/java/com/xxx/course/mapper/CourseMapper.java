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

    @Select("select * from pe_course")
    List<CourseDTO> listCourse();

    @Select("select user_id form pr_user_course where course_id = #{courseId}")
    Integer getCourseTeacher(@Param("courseId") int courseId);
}
