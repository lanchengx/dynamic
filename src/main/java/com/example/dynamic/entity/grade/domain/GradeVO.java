package com.example.dynamic.entity.grade.domain;

import com.dongpinyun.utils.BeanUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
* 成绩VO 对象
* @author 
* @date 2020年5月9日
*/
@Getter
@Setter
@Accessors(chain = true)
public class GradeVO implements Serializable {
    private static final long serialVersionUID = 1L;

	public GradeVO() {
	    super();
	}

	private Integer id;
	private Integer stuId;
	private Integer grade;


}