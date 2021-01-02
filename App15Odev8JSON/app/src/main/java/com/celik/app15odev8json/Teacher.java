package com.celik.app15odev8json;

public class Teacher {

    private String name;
    private int registry;

    public Teacher(String name, int registry) {
        this.name = name;
        this.registry = registry;
    }

    public String getName() {
        return name;
    }

    public int getRegistry() {
        return registry;
    }

    @Override
    public String toString() {
        return name;
    }
}
