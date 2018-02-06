package com.yy.crm.classes.service;

import com.yy.crm.classes.domain.CrmClasses;

import java.util.List;

public interface ClassesService {
    List<CrmClasses> findAll();

    CrmClasses queryClassById(String classId);

    void addOrEdit(CrmClasses crmClasses);

    CrmClasses findInfo(String classId);
}
