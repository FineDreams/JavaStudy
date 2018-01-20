package com.yy.employee.service;

import com.yy.employee.dao.EmployeeDao;
import com.yy.employee.domain.Employee;

import java.util.List;

public class EmployeeService {
    private EmployeeDao employeeDao=new EmployeeDao();

    public List<Employee> searchAll(){
        List<Employee> employees = employeeDao.queryAll();
        return employees;
    }

    public void addEmployee(Employee employee){
        employeeDao.insert(employee);
    }

    public Employee searchById(int id){
        Employee employee = employeeDao.queryById(id);
        return employee;
    }

    public void modifyEmployee(Employee employee){
        employeeDao.modify(employee);
    }

}
