package com.example.dynamic.entity.student;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * (Student)表实体类
 *
 * @author lanchengx
 * @since 2020-05-10 14:29:22
 */


@Getter
@Setter
@Accessors(chain = true)
@TableName(value = "student")
public class Student extends Model<Student> implements Serializable {

    private static final long serialVersionUID = -21342905253824696L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}