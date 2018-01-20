package com.yy.employee.dao;

import com.yy.employee.domain.Employee;
import com.yy.jar.HibernateUtil;
import org.hibernate.Query;

import java.util.List;

public class EmployeeDao {

    public List<Employee> queryAll(){
        List<Employee> employees = HibernateUtil.handle(session -> {
            Query query = session.createQuery("from " + Employee.class.getName());
            return query.list();
        });
        return employees;
    }

    public void insert(Employee employee){
        System.out.println(employee);
        HibernateUtil.handle(session -> {
            session.save(employee);
            return null;
        });

    }

    public Employee queryById(int id){
        Employee employee1 = HibernateUtil.handle(session -> {
            Employee employee = session.get(Employee.class, id);
            return employee;
        });
        return employee1;
    }

    public void modify(Employee employee){
        HibernateUtil.handle(session -> {
            session.update(employee);
            return null;
        });

    }

}
