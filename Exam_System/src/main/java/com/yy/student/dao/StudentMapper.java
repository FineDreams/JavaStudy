package com.yy.student.dao;

import com.yy.student.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(String stuNumber);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String stuNumber);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}