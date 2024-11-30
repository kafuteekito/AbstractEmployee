# Employee Management System

## Description
The Employee Management System is a JavaFX-based GUI application that allows users to manage a list of employees. The system supports three types of employees:

- **Full-Time Employees**
- **Part-Time Employees**
- **Contractors**

Each employee type has unique attributes and salary calculation logic. The application enables users to add employees to a table, calculate their salaries based on input parameters, and view their details in a structured format.

## Features
- **Add Employees**: Add employees by entering their name, type, and salary-related details.
- **Dynamic UI**: The interface adjusts based on the selected employee type to show relevant input fields.
- **Salary Calculation**: Automatically calculates salaries based on predefined rules for each employee type.
- **Table View**: Displays employee data, including name, type, and salary, in a table.

## Requirements
- Java 11 or higher
- JavaFX SDK
- IDE or build tool (e.g., IntelliJ IDEA, Eclipse, or Maven)

## Screenshots

### 1. Default View
![image](https://github.com/user-attachments/assets/8c5ca22d-e599-466b-9ece-4a05e170d4a6)

### 2. Full-Time Employee Input 
![image](https://github.com/user-attachments/assets/18f2a872-5a8d-44c6-9b6e-f1f150f2d303)

### 3. Part-Time Employee Input
![image](https://github.com/user-attachments/assets/7f90230b-94f6-4f7b-a505-eb05a3191933)

### 4. Contractor Employee Input
![image](https://github.com/user-attachments/assets/bc75329f-7281-49b3-a574-51ff653f5ff0)

## Sample Inputs

### Full-Time Employee
- **Name**: John Doe
- **Type**: Full-Time
- **Salary**: 50,000$

### Part-Time Employee
- **Name**: Jane Smith
- **Type**: Part-Time
- **Hourly Rate**: 20.5
- **Hours Worked**: 25
- **Calculated Salary**: $512.5

### Contractor Employee
- **Name**: Mark Johnson
- **Type**: Contractor
- **Hourly Rate**: 30
- **Hours Worked**: 160
- **Calculated Salary**: $4,800

## Notes
- Maximum billable hours for contractors are capped at 160 per month.
- Part-Time and Contractor salaries are dynamically calculated based on user input.
