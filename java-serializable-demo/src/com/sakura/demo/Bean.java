package com.sakura.demo;

import java.io.Serializable;
import java.util.Date;

public class Bean implements Serializable {

    private static final long serialVersionUID = -6193928364807891781L;

    private String name;
    private int age;
    private Date date;

    public Bean() {
    }

    public Bean(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
