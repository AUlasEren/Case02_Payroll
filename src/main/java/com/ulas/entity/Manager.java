package com.ulas.entity;

public class Manager extends Employee {
    private static final double HOURLY_RATE = 500;

    public Manager(String name, String surname) {
        super(name, surname, "Manager");
    }

    @Override
    public double calculateSalary(int hours) {
        double bonus = 5000;
        return (hours * HOURLY_RATE) + bonus;
    }
}
