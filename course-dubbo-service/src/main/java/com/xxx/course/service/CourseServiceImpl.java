package com.xxx.course.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xxx.course.domain.dto.CourseDTO;
import com.xxx.course.mapper.CourseMapper;
import com.xxx.course.thrift.ServiceProvider;
import com.xxx.thrift.user.UserInfo;
import com.xxx.thrift.user.domain.dto.TeacherDTO;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Service(interfaceClass = ICourseService.class)
@Component
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private ServiceProvider serviceProvider;

    @Override
    public List<CourseDTO> courseList() {
        List<CourseDTO> courseDTOS = courseMapper.listCourse();
        if (courseDTOS != null){
            for (CourseDTO courseDTO : courseDTOS) {
                Integer teacherId = courseMapper.getCourseTeacher(courseDTO.getId());
                if (teacherId != null){
                    try {
                        UserInfo userInfo = serviceProvider.getUserService().getTeacherById(teacherId);
                        courseDTO.setTeacherDTO(trans2Teacher(userInfo));
                    } catch (TException e) {
                        e.printStackTrace();
                        return null;
                    }
                }

            }
        }

        return courseDTOS;
    }


    private TeacherDTO trans2Teacher(UserInfo userInfo){
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(userInfo, teacherDTO);
        return teacherDTO;
    }
}
