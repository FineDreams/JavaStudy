package com.yy.crm.course.dao.impl;

import com.yy.crm.course.dao.CourseDao;
import com.yy.crm.course.domain.CrmCourseType;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {
    @Override
    public List<CrmCourseType> queryAll() {
        System.out.println("测试测试测试测试");
        List<CrmCourseType> courseType_list = (List<CrmCourseType>) this.getHibernateTemplate().find("from CrmCourseType ");
        return courseType_list;
    }

    @Override
    public CrmCourseType queryCourseById(String typeId) {
        List<CrmCourseType> list = (List<CrmCourseType>) this.getHibernateTemplate().find("from CrmCourseType c where c.courseTypeId=?", typeId);
        return list.get(0);
    }

    @Override
    public void addOrEdit(CrmCourseType crmCourseType) {
        String courseTypeId = crmCourseType.getCourseTypeId();
        if (courseTypeId.equals("")){
            this.getHibernateTemplate().save(crmCourseType);
        }else{
            this.getHibernateTemplate().update(crmCourseType);
        }
    }

    @Override
    public List<CrmCourseType> searchGroup(String sb) {

        List<CrmCourseType> list = (List<CrmCourseType>) this.getHibernateTemplate().find(sb);
        return list;
    }

}
