package com.example.dynamic.service.student;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.dynamic.entity.student.Student;

/**
 * (Student)表服务接口
 *
 * @author lanchengx
 * @since 2020-05-10 14:29:22
 */
public interface StudentService extends IService<Student> {
    /**
     * slave  数据库添加
     *
     * @param stu
     * @return
     */
    Student slaveSave(Student stu);

    /**
     * master 数据库添加
     *
     * @param stu
     * @return
     */
    Student masterSave(Student stu);

    /**
     * 写库查询
     *
     * @param id
     * @return
     */
    Student getMasterStudent(Integer id);
}