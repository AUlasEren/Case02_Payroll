package com.ulas.entity;

import com.ulas.enums.Degree;

public abstract class Employee implements IEmployee {
    protected String name;
    protected String surname;
    protected String role;
    protected Degree degree;
    protected int hoursWorked;

    public Employee(String name, String surname, String role) {
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public String getName() {
        return name + " " + surname;
    }

    // Implement setDegree in subclasses if needed
    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public abstract double calculateSalary(int hours);
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }
}
