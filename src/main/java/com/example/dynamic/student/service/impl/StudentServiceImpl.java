package com.example.dynamic.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic.entity.student.domain.StudentPO;
import com.example.dynamic.student.dao.StudentDAO;
import com.example.dynamic.student.service.StudentService;
import org.springframework.stereotype.Service;

/**
* 学生的业务实现类
* @author 
* @date 2020年5月9日
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDAO,StudentPO> implements StudentService {

}