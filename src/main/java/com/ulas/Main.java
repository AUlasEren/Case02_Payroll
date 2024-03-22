package com.ulas;

import com.ulas.entity.Employee;
import com.ulas.entity.Manager;
import com.ulas.entity.Officer;
import com.ulas.service.FileReader;
import com.ulas.service.PayrollService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ulas_\\OneDrive\\Masaüstü\\personel.json.txt";
        List<Employee> employeeList = FileReader.readEmployeeList(filePath);

        for (Employee employee : employeeList) {
            int workingHours = 160;
            double salary = employee.calculateSalary(workingHours);


            String payrollMonth = "April 2024";
            PayrollService.savePayrollInfo(employee, payrollMonth, salary, 0, salary);

            System.out.println(employee.getName() + "'s salary calculation and saving process completed. Total Payment: " + salary + " TL");
        }

        System.out.println("Payroll processing completed.");
    }
}