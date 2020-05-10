package com.example.dynamic;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dynamic.service.grade.GradeService;
import com.example.dynamic.entity.student.Student;
import com.example.dynamic.service.student.StudentService;
import com.example.dynamic.util.ServiceException;
import com.example.dynamic.service.webservice.WebService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DynamicApplicationTests {

    @Autowired
    GradeService gradeService;
    @Autowired
    StudentService studentService;
    @Autowired
    WebService webService;

    @Test
    void testWriteInsert() {
        Student lan = new Student()
                .setName("lanMaster4")
                .setAge(23)
                .setSex(1);
        studentService.save(lan);
    }

    @Test
    void testSlaveInsert() {
        Student lan = new Student()
                .setName("lanSlave3")
                .setAge(23)
                .setSex(1);
        studentService.slaveSave(lan);

    }

    /**
     * 测试全表删除
     */
    @Test
    void testDeleteAll() {
        studentService.remove(Wrappers.emptyWrapper());
    }

    /**
     * 测试全表更新
     */
    @Test
    void testUpdateAll() {
        studentService.update(Wrappers.emptyWrapper());
    }

    @Test
    void testPageLimit() {
        Page<Student> page = new Page()
                .setCurrent(0L)
                .setSize(4);
        LambdaQueryWrapper<Student> query = Wrappers.<Student>lambdaQuery()
                .like(Student::getName, "lan");
        page = studentService.page(page, query);
        page.getRecords().stream().map(Student::getName).forEach(System.out::println);
    }

    @Test
    void testTransactional() {
        try {
            webService.testTransactional();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testAop() {
        // aop 切换至读库
        System.out.println("=============读库查询开始============= ");
        LambdaQueryWrapper<Student> query = Wrappers.<Student>lambdaQuery()
                .like(Student::getName, "lan");
        List<Student> list = studentService.list(query);
        list.stream().map(Student::getName).forEach(System.out::println);
        System.out.println("=============读库查询完成============= ");

        // aop  切换至写库
        Student lan = new Student()
                .setName("lanAop")
                .setAge(23)
                .setSex(1);
        studentService.save(lan);
        System.out.println("写库添加name： " + lan.getName());

        // 注解写库查询
        Student masterStudent = studentService.getMasterStudent(lan.getId());
        System.out.println("写库查询name： " + masterStudent.getName());

    }
}
