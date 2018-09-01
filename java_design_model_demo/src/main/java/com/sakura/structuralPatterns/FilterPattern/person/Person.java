package com.sakura.structuralPatterns.FilterPattern.person;

/**
 * @author licunzhi
 * @desc the object be filtered
 * @date 2018-09-01
 */
public class Person {

    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name, String gender, String maritalStatus) {
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", gender='" + gender + '\'' + ", maritalStatus='" + maritalStatus
                        + '\'' + '}';
    }
}

