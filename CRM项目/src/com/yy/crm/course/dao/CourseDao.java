package com.yy.crm.course.dao;

import com.yy.crm.course.domain.CrmCourseType;

import java.util.List;

public interface CourseDao {
    List<CrmCourseType> queryAll();
    CrmCourseType queryCourseById(String typeId);
    void addOrEdit(CrmCourseType crmCourseType);
    List<CrmCourseType> searchGroup(String sb);
}
