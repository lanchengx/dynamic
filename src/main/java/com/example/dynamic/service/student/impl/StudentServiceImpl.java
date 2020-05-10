package com.example.dynamic.service.student.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dynamic.dao.student.StudentDao;
import com.example.dynamic.service.student.StudentService;
import com.example.dynamic.entity.student.Student;
import org.springframework.stereotype.Service;

/**
 * (Student)表服务实现类
 *
 * @author lanchengx
 * @since 2020-05-10 14:29:22
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

    @Override
    @DS("slave")
    public Student slaveSave(Student stu) {
        stu.insert();
        return stu;
    }

    @Override
    public Student masterSave(Student stu) {
        stu.insert();
        return stu;
    }

    @Override
    @DS("master")
    public Student getMasterStudent(Integer id) {
        return this.getById(id);
    }
}