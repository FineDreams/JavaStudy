package com.yy.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yy.employee.domain.Employee;
import com.yy.employee.service.EmployeeService;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class EmployeeAction extends ActionSupport{
    private EmployeeService employeeService=new EmployeeService();
    private Employee employee;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String showAll(){
        List<Employee> employeeList = employeeService.searchAll();
        ActionContext.getContext().put("employeeList",employeeList);
        return "show";
    }

    public String add(){
        System.out.println(employee.toString());
        employeeService.addEmployee(employee);
        return "add";
    }

    public String search(){
        Employee employee = employeeService.searchById(id);
        ActionContext.getContext().put("employee",employee);
        return "search";
    }

    public String modify(){
        employeeService.modifyEmployee(employee);
        return "modify";
    }
}
