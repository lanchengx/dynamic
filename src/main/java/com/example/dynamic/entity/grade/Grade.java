package com.example.dynamic.entity.grade;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * (Grade)表实体类
 *
 * @author lanchengx
 * @since 2020-05-10 14:25:19
 */


@Getter
@Setter
@Accessors(chain = true)
@TableName(value = "grade")
public class Grade extends Model<Grade> implements Serializable {

    private static final long serialVersionUID = 235332148762569567L;

    //id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer stuId;

    //年级
    private Integer grade;


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