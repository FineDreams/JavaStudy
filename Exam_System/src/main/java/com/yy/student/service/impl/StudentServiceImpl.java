package com.yy.student.service.impl;

import com.yy.student.dao.StudentMapper;
import com.yy.student.domain.Student;
import com.yy.student.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void insertStudent(Student student) {
        studentMapper.insertSelective(student);
    }

    @Override
    public Student selectStudentByNumber(String stuNumber) {
        Student studentFromDB=studentMapper.selectByPrimaryKey(stuNumber);
        return studentFromDB;
    }
}
