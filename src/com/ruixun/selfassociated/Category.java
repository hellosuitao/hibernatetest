package com.ruixun.selfassociated;

import javax.persistence.SecondaryTable;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashSet;
import java.util.Set;

public class Category {
    private Integer id;
    private String name;
    private Category parent;
    private Set<Category> childs = new HashSet<>();

    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Set<Category> getChilds() {
        return childs;
    }

    public void setChilds(Set<Category> childs) {
        this.childs = childs;
    }
}
