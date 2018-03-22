package com.yy.student.service;

import com.yy.student.domain.Student;

public interface StudentService {
    void insertStudent(Student student);

    Student selectStudentByNumber(String stuNumber);

}
