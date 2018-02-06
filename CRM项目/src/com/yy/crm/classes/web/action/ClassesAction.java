package com.yy.crm.classes.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.crm.classes.domain.CrmClasses;
import com.yy.crm.classes.service.ClassesService;

import java.util.List;

public class ClassesAction extends ActionSupport {

    private ClassesService classesService;
    private CrmClasses crmClasses;

    public CrmClasses getCrmClasses() {
        return crmClasses;
    }

    public void setCrmClasses(CrmClasses crmClasses) {
        this.crmClasses = crmClasses;
    }

    public void setClassesService(ClassesService classesService) {
        this.classesService = classesService;
    }

    public String findAll(){
        List<CrmClasses> crmClassesList=classesService.findAll();
//        ActionContext.getContext().put("classesList",crmClassesList);
        ActionContext.getContext().getValueStack().set("classesList",crmClassesList);
        return "findAll";
    }

    public String queryClassById(){
        CrmClasses classes=classesService.queryClassById(crmClasses.getClassId());
        ActionContext.getContext().put("classes",classes);
        return "queryClassById";
    }

    public String addOrEdit(){
        classesService.addOrEdit(crmClasses);
        return "addOrEdit";
    }

    public String findInfo(){
        CrmClasses classesServiceInfo=classesService.findInfo(crmClasses.getClassId());
        ActionContext.getContext().put("classInfo",classesServiceInfo);
        return "findInfo";
    }

}
