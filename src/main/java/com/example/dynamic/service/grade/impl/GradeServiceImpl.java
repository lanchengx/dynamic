package com.example.dynamic.service.grade.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic.dao.grade.GradeDao;
import com.example.dynamic.entity.grade.Grade;
import com.example.dynamic.service.grade.GradeService;
import org.springframework.stereotype.Service;

/**
 * (Grade)表服务实现类
 *
 * @author lanchengx
 * @since 2020-05-10 14:25:19
 */
@Service("gradeService")
public class GradeServiceImpl extends ServiceImpl<GradeDao, Grade> implements GradeService {

}