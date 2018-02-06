package com.yy.crm.course.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.crm.course.domain.CrmCourseType;
import com.yy.crm.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseAction extends ActionSupport{
    private CourseService courseService;
//    private String courseTypeId;
    private String courseName;
    private String remark;
    private Integer totalStart;
    private Integer totalEnd;
    private Double lessonCostStart;
    private Double lessonCostEnd;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(Integer totalStart) {
        this.totalStart = totalStart;
    }

    public Integer getTotalEnd() {
        return totalEnd;
    }

    public void setTotalEnd(Integer totalEnd) {
        this.totalEnd = totalEnd;
    }

    public Double getLessonCostStart() {
        return lessonCostStart;
    }

    public void setLessonCostStart(Double lessonCostStart) {
        this.lessonCostStart = lessonCostStart;
    }

    public Double getLessonCostEnd() {
        return lessonCostEnd;
    }

    public void setLessonCostEnd(Double lessonCostEnd) {
        this.lessonCostEnd = lessonCostEnd;
    }

    @Autowired
    private CrmCourseType crmCourseType;

    public CrmCourseType getCrmCourseType() {
        return crmCourseType;
    }

    public void setCrmCourseType(CrmCourseType crmCourseType) {
        this.crmCourseType = crmCourseType;
    }


    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
//查找所有课程
    public String  queryAllCourse(){
        List<CrmCourseType> allCourse = courseService.findAllCourse();
        ActionContext.getContext().put("courses",allCourse);
        return "allCourse";
    }
//通过ID查找课程，编辑课程方法
    public String queryCourseById(){
        CrmCourseType courseType = courseService.searchCourseById(crmCourseType.getCourseTypeId());
        ActionContext.getContext().put("courseType",courseType);
        return "queryById";
    }

//    增加或者编辑课程
    public String addOrEdit(){
//        System.out.println(crmCourseType.getCourseTypeId()+"========测试id=====");
//        System.out.println(crmCourseType.toString()+"插入前课程");
//        System.out.println(crmCourseType.toString()+"---插入后测试课程---");
        courseService.addOrEdit(crmCourseType);
        return "addOrEdit";
    }

    public String searchGroup(){
        List<CrmCourseType> courseTypeList=courseService.searchGroup(courseName,remark,totalStart,totalEnd,lessonCostStart,lessonCostEnd);
        ActionContext.getContext().put("courses",courseTypeList);
        return "searchGroup";
    }
}
