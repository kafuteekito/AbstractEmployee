package org.example.abstractemployee;

public class FullTime extends Employee {
    public FullTime(String name) {
        super(name, EmployeeType.FULL_TIME);
        this.salary = 50000.0;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
