package com.ulas.entity;

import com.ulas.enums.Degree;


public class Officer extends Employee {
    private double hourlyRate;

    public Officer(String name, String surname, Degree degree) {
        super(name, surname, "Officer");
        setDegree(degree);
        this.hourlyRate = determineHourlyRate();
    }

    private double determineHourlyRate() {
        switch (this.degree) {
            case JUNIOR:
                return 300;
            case MID:
                return 400;
            case SENIOR:
                return 500;
            default:
                return 300;
        }
    }

    @Override
    public double calculateSalary(int hours) {
        double totalSalary;
        if (hours > 180) {
            int overtimeHours = hours - 180;

            double overtimePayment = overtimeHours * (this.hourlyRate * 1.5);
            totalSalary = (180 * this.hourlyRate) + overtimePayment;
        } else {
            totalSalary = hours * this.hourlyRate;
        }
        return totalSalary;
    }
}

