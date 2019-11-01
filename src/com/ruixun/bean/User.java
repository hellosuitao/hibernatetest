package com.ruixun.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private Integer id;
    private String name;
    private String address;
    private Set<String> hobbies;
    private List<String> works;
    private Map<String,String> city;
}
