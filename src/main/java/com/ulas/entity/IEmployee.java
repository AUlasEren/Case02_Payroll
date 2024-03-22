package com.ulas.entity;

import com.ulas.enums.Degree;

public interface IEmployee {
    String getName();
    double calculateSalary(int hours);
    void setDegree(Degree degree);
}

