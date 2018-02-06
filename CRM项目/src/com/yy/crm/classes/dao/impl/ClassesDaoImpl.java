package com.yy.crm.classes.dao.impl;

import com.yy.crm.classes.dao.ClassesDao;
import com.yy.crm.classes.domain.CrmClasses;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class ClassesDaoImpl extends HibernateDaoSupport implements ClassesDao {

    @Override
    public List<CrmClasses> findAll() {
        List<CrmClasses> crmClassesList = (List<CrmClasses>) this.getHibernateTemplate().find("from CrmClasses ");
        return crmClassesList;
    }

    @Override
    public CrmClasses queryClassById(String classId) {
        List<CrmClasses> crmClassesList= (List<CrmClasses>) this.getHibernateTemplate().find("from CrmClasses cc where cc.classId=?", classId);
        return crmClassesList.get(0);
    }

    @Override
    public void addOrEdit(CrmClasses crmClasses) {
        String classId = crmClasses.getClassId();
//        System.out.println(classId+"测试classId");

        if (classId.equals("")){
            this.getHibernateTemplate().save(crmClasses);
        }else {
//            this.getHibernateTemplate().update(crmClasses);
            CrmClasses crmClasses1 = this.getHibernateTemplate().get(CrmClasses.class, classId);
            crmClasses1.setName(crmClasses.getName());
            crmClasses1.setCrmCourseType(crmClasses.getCrmCourseType());
            crmClasses1.setBeginTime(crmClasses.getBeginTime());
            crmClasses1.setEndTime(crmClasses.getEndTime());
            crmClasses1.setRemark(crmClasses.getRemark());
        }
    }

    @Override
    public CrmClasses findInfo(String classId) {
        List<CrmClasses> list = (List<CrmClasses>) this.getHibernateTemplate().find("from CrmClasses cc where cc.classId=?", classId);
        return list.get(0);
    }

}
