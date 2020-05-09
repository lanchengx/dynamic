package com.example.dynamic.grade.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic.entity.grade.domain.GradePO;
import com.example.dynamic.grade.dao.GradeDAO;
import com.example.dynamic.grade.service.GradeService;
import org.springframework.stereotype.Service;

/**
* 成绩的业务实现类
* @author 
* @date 2020年5月9日
*/
@Service
public class GradeServiceImpl extends ServiceImpl<GradeDAO,GradePO> implements GradeService {

}