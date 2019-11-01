package com.ruixun.bean;

import lombok.Data;

import java.util.Set;

@Data
public class Employee {
    private Integer id;
    private String name;
//    private Set<Department> departments;
//    private Department department;
    private Department department;

}
