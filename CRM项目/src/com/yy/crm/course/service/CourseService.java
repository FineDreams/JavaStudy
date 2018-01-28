package com.yy.crm.course.service;

import com.yy.crm.course.domain.CrmCourseType;

import java.util.List;

public interface CourseService {
    List<CrmCourseType> findAllCourse();
    CrmCourseType searchCourseById(String typeId);
    void addOrEdit(CrmCourseType crmCourseType);

    List<CrmCourseType> searchGroup(String courseName, String remark, Integer totalStart, Integer totalEnd, Double lessonCostStart, Double lessonCostEnd);
}
