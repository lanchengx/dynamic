package com.example.dynamic.service.webservice.impl;

import com.example.dynamic.entity.grade.Grade;
import com.example.dynamic.service.grade.GradeService;
import com.example.dynamic.entity.student.Student;
import com.example.dynamic.service.student.StudentService;
import com.example.dynamic.util.ServiceException;
import com.example.dynamic.service.webservice.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: lanchengx
 * @Date: 2020/5/10 0010
 */
@Service
public class WebServiceImpl implements WebService {

    @Autowired
    GradeService gradeService;
    @Autowired
    StudentService studentService;

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void testTransactional() throws ServiceException {
        gradeService.save(new Grade().setStuId(1).setGrade(20));
        studentService.save(new Student().setName("lanTransactional").setAge(23).setSex(1));
        throw new ServiceException("test EX");
    }
}
