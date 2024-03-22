package com.ulas.service;

import com.ulas.entity.Employee;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PayrollService {
    public static void savePayrollInfo(Employee employee, String payrollMonth, double basePayment, double overtimePayment, double totalPayment) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("payroll", payrollMonth);
        JSONObject employeeObj = new JSONObject();
        employeeObj.put("name", employee.getName());
        employeeObj.put("hoursWorked", employee.getHoursWorked());
        JSONObject paymentDetails = new JSONObject();
        paymentDetails.put("basePayment", String.format("₺%,.2f", basePayment));
        paymentDetails.put("overtimePayment", String.format("₺%,.2f", overtimePayment));
        paymentDetails.put("totalPayment", String.format("₺%,.2f", totalPayment));
        employeeObj.put("paymentDetails", paymentDetails);
        jsonObject.put("employee", employeeObj);

        try {
            String folderName = "payrolls/" + employee.getName().replace(" ", "_");
            Files.createDirectories(Paths.get(folderName));
            Path filePath = Paths.get(folderName, payrollMonth.replaceAll(" ", "_") + ".json");
            Files.write(filePath, jsonObject.toString(4).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
