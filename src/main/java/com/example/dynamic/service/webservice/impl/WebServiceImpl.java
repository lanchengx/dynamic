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
    public void testSaveTransactional() throws ServiceException {
        gradeService.save(new Grade().setStuId(1).setGrade(20));
        studentService.save(new Student().setName("lanTransactional").setAge(23).setSex(1));
        throw new ServiceException("test EX");
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public void testSaveAndGetTransactional(String name) throws ServiceException {
        Student stu = new Student().setName(name).setAge(23).setSex(1);
        studentService.save(stu);
        System.out.println("保存id : " + stu.getId() + "name : " + stu.getName() + "成功");
        studentService.getById(stu.getId());
        System.out.println("查询id : " + stu.getId() + "name : " + stu.getName() + "成功");
    }

    @Override
    public void testSaveAndGet(String name) throws ServiceException {
        Student stu = new Student().setName(name).setAge(23).setSex(1);
        studentService.save(stu);
        System.out.println("保存id : " + stu.getId() + "name : " + stu.getName() + "成功");
        studentService.getById(stu.getId());
        System.out.println("查询id : " + stu.getId() + "name : " + stu.getName() + "成功");
    }

    @Override
    public void testGetAndSave(Integer getId, String saveName) throws ServiceException {
        Student sutById = studentService.getById(getId);
        if (sutById == null) {
            System.out.println("第一次查询为null");
        } else {
            System.out.println("第一次查询id : " + getId + "， name : " + sutById.getName() + "成功");
        }
        Student stu = new Student().setName(saveName).setAge(23).setSex(1);
        studentService.save(stu);
        System.out.println("保存id : " + stu.getId() + "， name : " + stu.getName() + "成功");
        studentService.getById(stu.getId());
        System.out.println("第二次查询id : " + stu.getId() + "， name : " + stu.getName() + "成功");
    }

    @Override
    @Transactional
    public void testGetAndSaveTransactional(Integer getId, String saveName) throws ServiceException {
        Student sutById = studentService.getById(getId);
        if (sutById == null) {
            System.out.println("第一次查询为null");
        } else {
            System.out.println("第一次查询id : " + getId + "， name : " + sutById.getName() + "成功");
        }
        Student stu = new Student().setName(saveName).setAge(23).setSex(1);
        studentService.save(stu);
        System.out.println("保存id : " + stu.getId() + "， name : " + stu.getName() + "成功");
        studentService.getById(stu.getId());
        System.out.println("第二次查询id : " + stu.getId() + "， name : " + stu.getName() + "成功");
    }

    @Override
    @Transactional
    public void listGetAndSaveTransactional(Integer getId, String saveName) throws ServiceException {
        Student sutById = studentService.getById(getId);
        if (sutById == null) {
            System.out.println("第一次查询为null");
        } else {
            System.out.println("第一次查询id : " + getId + "， name : " + sutById.getName() + "成功");
        }
        Student stu = new Student().setName(saveName).setAge(23).setSex(1);
        studentService.save(stu);
        System.out.println("保存id : " + stu.getId() + "， name : " + stu.getName() + "成功");
        studentService.getById(stu.getId());
        System.out.println("第二次查询id : " + stu.getId() + "， name : " + stu.getName() + "成功");
    }
}
