package com.celik.app16odev8jsonalternatifcozum;


public class Lesson {

    String code;
    String name;
    int teacherRegistry;
    int credit;


    public Lesson(String code, String name, int teacherRegistry, int credit) {
        this.code = code;
        this.name = name;
        this.teacherRegistry = teacherRegistry;
        this.credit = credit;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherRegistry() {
        return teacherRegistry;
    }

    public void setTeacherRegistry(int teacherRegistry) {
        this.teacherRegistry = teacherRegistry;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return name;
    }
}