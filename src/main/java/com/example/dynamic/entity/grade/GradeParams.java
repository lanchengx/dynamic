package com.example.dynamic.entity.grade;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
public class GradeParams implements Serializable {

    private static final long serialVersionUID = 771087339996467684L;
    //id    
    private Integer id;

    private Integer stuId;
    //年级    
    private Integer grade;


}