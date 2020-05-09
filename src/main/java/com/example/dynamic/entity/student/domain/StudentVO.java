package com.example.dynamic.entity.student.domain;

import com.dongpinyun.utils.BeanUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
* 学生VO 对象
* @author 
* @date 2020年5月9日
*/
@Getter
@Setter
@Accessors(chain = true)
public class StudentVO implements Serializable {
    private static final long serialVersionUID = 1L;

	public StudentVO() {
	    super();
	}

	private Integer id;
	private String name;
	private Integer age;
	private Integer sex;


}