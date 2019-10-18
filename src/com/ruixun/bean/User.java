package com.ruixun.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private Integer id;
    private String name;
    private String address;
    private Set<String> hobbies;
    private List<String> works;
    private Map<String,String> city;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getWorks() {
        return works;
    }

    public void setWorks(List<String> works) {
        this.works = works;
    }

    public Map<String, String> getCity() {
        return city;
    }

    public void setCity(Map<String, String> city) {
        this.city = city;
    }

    public User(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
