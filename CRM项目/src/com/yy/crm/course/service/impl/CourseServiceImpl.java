package com.yy.crm.course.service.impl;

import com.yy.crm.course.dao.CourseDao;
import com.yy.crm.course.domain.CrmCourseType;
import com.yy.crm.course.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<CrmCourseType> findAllCourse() {
        List<CrmCourseType> crmCourseTypes = courseDao.queryAll();
        return crmCourseTypes;
    }

    @Override
    public CrmCourseType searchCourseById(String typeId) {
        CrmCourseType crmCourseType = courseDao.queryCourseById(typeId);
        return crmCourseType;
    }

    @Override
    public void addOrEdit(CrmCourseType crmCourseType) {
        courseDao.addOrEdit(crmCourseType);
    }

    @Override
    public List<CrmCourseType> searchGroup(String courseName, String remark, Integer totalStart, Integer totalEnd, Double lessonCostStart, Double lessonCostEnd) {
        StringBuilder sb=new StringBuilder("from CrmCourseType cmt where 1=1 ");
//        System.out.println("courseName:"+courseName);
//        System.out.println("remark:"+remark);
//        System.out.println("totalStart:"+totalStart);
//        System.out.println("lessonCostStart:"+lessonCostStart);

        if (!courseName.equals("")){
            sb.append(" and cmt.courseName='"+courseName+"'");
        }
        if (!remark.equals("")){
            sb.append(" and cmt.remark like '%"+remark+"%'");
        }
//        System.out.println(sb.toString()+"--------1----------");
        if ((totalStart!=null)&&(totalEnd!=null)){
            sb.append(" and cmt.total between "+totalStart+" and "+totalEnd);
        }
        if ((totalStart==null)&&(totalEnd!=null)){
            sb.append(" and cmt.total <= '"+totalEnd+"'");
        }
        if ((totalStart!=null)&&totalEnd==null){
            sb.append(" and cmt.total >= '"+totalStart+"'");
        }
        if ((lessonCostStart!=null)&&(lessonCostEnd!=null)){
            sb.append(" and cmt.courseCost between "+lessonCostStart+" and "+lessonCostEnd);
        }
        if (lessonCostStart==null&&(lessonCostEnd!=null)){
            sb.append(" and cmt.courseCost <= '"+lessonCostEnd+"'");
        }
        if (lessonCostEnd==null&&(lessonCostStart!=null)){
            sb.append(" and cmt.courseCost >="+lessonCostStart);
        }
//        System.out.println(sb.toString()+"-----SQL语句");
        List<CrmCourseType> courseTypeList = courseDao.searchGroup(sb.toString());
        return courseTypeList;
    }


}
