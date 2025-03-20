package com.example.security.model;

public class Students {

    private String name;
    private int marks;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Students(String name, int marks, int id) {
        this.name = name;
        this.marks = marks;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", marks='" + marks + '\'' +
                ", id=" + id +
                '}';
    }
}
