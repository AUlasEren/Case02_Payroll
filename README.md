# Payroll System for a Small Company

This Java application calculates the salaries of different types of employees (Managers and Officers) in a small company, considering their working hours, roles, and, for officers, their ranks (Junior, Mid, Senior). The system reads employee information from a JSON file, performs the salary calculations, and saves the payroll information into individual JSON files for each employee.

## Features
- **Flexible Salary Calculation**: Calculates salaries based on role, working hours, and rank (for officers).
- **Overtime Pay**: Automatically calculates overtime pay for officers working more than 180 hours.
- **Bonus for Managers**: Includes a fixed bonus in the salary calculation for managers.
- **JSON Input/Output**: Reads employee information from a JSON file and outputs payroll information into separate JSON files.

## How to Use
1. **Prepare the Employee JSON File**: Create a JSON file named `personel.json.txt` containing the list of employees with their names, surnames, roles, and (for officers) their ranks. Example:
```json
[
  {
    "name": "Fatih",
    "surname": "Alkan",
    "role": "Manager"
  },
  {
    "name": "Beyazıt",
    "surname": "Dalgıç",
    "role": "Officer",
    "degree": "Senior"
  }
]
```
## Requirements
Java 8 or newer
JSON library (e.g., org.json)
## Project Structure
- **entities**: Contains the Employee, Manager, and Officer classes.
- **enums**: Contains the Degree enum for officer ranks.
- **interfaces**: Contains the IEmployee interface.
- **services**: Contains the FileReader and PayrollService classes for reading input and writing output.