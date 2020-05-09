package com.example.dynamic.entity.grade.domain;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.example.dynamic.entity.BaseVO;
import com.example.dynamic.util.BeanUtils;
import com.example.dynamic.util.CamelUnderlineTransformerUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collections;
import java.util.Arrays;


/**
* 成绩Query 对象
* @author 
* @date 2020年5月9日
*/
@Getter
@Setter
@Accessors(chain = true)
public class GradeQuery extends BaseVO implements Serializable{
    private static final long serialVersionUID = 1L;

	public GradeQuery() {
	    super();
	}

	private Integer id;
	private Integer stuId;
	private Integer grade;

	public QueryWrapper<GradePO> getQueryWrappers() {
            GradePO po = new GradePO();
            BeanUtils.copy(this, po);
            QueryWrapper<GradePO> wrapper = Wrappers.<GradePO>query().setEntity(po);

            wrapper.orderBy(!StringUtils.isBlank(this.getSortBy()), "asc".equalsIgnoreCase(this.getDirection()), CamelUnderlineTransformerUtil.camelToUnderline(this.getSortBy()));
            return wrapper;
        }
    public UpdateWrapper<GradePO> getUpdateWrappers() {
            GradePO po = new GradePO();
            BeanUtils.copy(this, po);
            UpdateWrapper<GradePO> wrapper = Wrappers.<GradePO>update().setEntity(po);
            return wrapper;
        }

}