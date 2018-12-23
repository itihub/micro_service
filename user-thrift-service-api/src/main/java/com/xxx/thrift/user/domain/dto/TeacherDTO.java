package com.xxx.thrift.user.domain.dto;

import lombok.Data;

/**
 * @Description: TODO
 * @Author: JiZhe
 */
@Data
public class TeacherDTO extends UserDTO {

    private String intro;

    private Integer stars;

}
