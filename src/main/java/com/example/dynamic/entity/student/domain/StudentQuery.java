package com.example.dynamic.entity.student.domain;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.dongpinyun.domain.base.BaseVO;
import com.dongpinyun.utils.BeanUtils;
import com.dongpinyun.utils.StringUtils;
import com.dongpinyun.base.utils.CamelUnderlineTransformerUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collections;
import java.util.Arrays;


/**
* 学生Query 对象
* @author 
* @date 2020年5月9日
*/
@Getter
@Setter
@Accessors(chain = true)
public class StudentQuery extends BaseVO implements Serializable{
    private static final long serialVersionUID = 1L;

	public StudentQuery() {
	    super();
	}

	private Integer id;
	private String name;
	private Integer age;
	private Integer sex;

	public QueryWrapper<StudentPO> getQueryWrappers() {
            StudentPO po = new StudentPO();
            BeanUtils.copy(this, po);
            QueryWrapper<StudentPO> wrapper = Wrappers.<StudentPO>query().setEntity(po);

            wrapper.orderBy(!StringUtils.isBlank(this.getSortBy()), "asc".equalsIgnoreCase(this.getDirection()), CamelUnderlineTransformerUtil.camelToUnderline(this.getSortBy()));
            return wrapper;
        }
    public UpdateWrapper<StudentPO> getUpdateWrappers() {
            StudentPO po = new StudentPO();
            BeanUtils.copy(this, po);
            UpdateWrapper<StudentPO> wrapper = Wrappers.<StudentPO>update().setEntity(po);
            return wrapper;
        }

}