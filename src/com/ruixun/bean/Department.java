package com.ruixun.bean;

import lombok.Data;

import java.util.Set;

@Data
public class Department {
    private Integer id;
    private String name;
//    private Set<Employee> employees;
    private Employee employee;
}
