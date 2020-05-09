package com.example.dynamic.entity.student.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.example.dynamic.util.BeanUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
* 学生的持久对象
* @author 
* @date 2020年5月9日
*/

@Getter
@Setter
@Accessors(chain = true)
@TableName(value = "student")
public class StudentPO implements Serializable {
    private static final long serialVersionUID = 1L;

	public StudentPO() {
        super();
    }

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String name;
	private Integer age;
	private Integer sex;

    /**
     * 将po对象转化为当前vo对象
     * <pre>
     * 案例：
     * VO vo = new PO().covertToVO()
     * </pre>
     *
     */
	public StudentVO convertToVO() {
            return BeanUtils.copy(this, new StudentVO());
        }

    /**
     * 将po对象转化为任意对象
     * 目标对象中具备相同类型相同名称的字段
     * <pre>
     * 案例：
     * OtherVO vo = new PO().convertTo(new OtherVO())
     * </pre>
     *
     */
    public <E extends Object> E convertTo(E e) {
        return BeanUtils.copy(this, e);
    }

}