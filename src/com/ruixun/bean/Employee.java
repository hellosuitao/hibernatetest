package com.ruixun.bean;

import java.util.Set;

public class Employee {
    private Integer id;
    private String name;
//    private Set<Department> departments;
//    private Department department;
    private Department department;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee(Integer id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
}
