package com.ruixun.bean;

import java.util.Set;

public class Department {
    private Integer id;
    private String name;
//    private Set<Employee> employees;
    private Employee employee;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department(Integer id, String name, Employee employee) {
        this.id = id;
        this.name = name;
        this.employee = employee;
    }
}
