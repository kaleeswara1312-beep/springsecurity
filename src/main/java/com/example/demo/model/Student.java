package com.example.demo.model;

public class Student {

    private int id;
    private String name;
    private String dep;

    public Student(int id, String name, String dep) {
        this.id = id;
        this.name = name;
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }
}
