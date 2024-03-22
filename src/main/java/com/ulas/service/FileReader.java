package com.ulas.service;

import com.ulas.entity.Employee;
import com.ulas.entity.Manager;
import com.ulas.entity.Officer;
import com.ulas.enums.Degree;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<Employee> readEmployeeList(String filePath) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray jsonArray = new JSONArray(content);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String surname = jsonObject.getString("surname");
                String role = jsonObject.getString("role");

                Employee employee = null;
                if ("Manager".equals(role)) {
                    employee = new Manager(name, surname);
                } else if ("Officer".equals(role)) {
                    Degree degree = Degree.valueOf(jsonObject.getString("degree").toUpperCase());
                    employee = new Officer(name, surname, degree);
                }

                if (employee != null) {
                    employeeList.add(employee);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}

