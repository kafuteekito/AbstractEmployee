package org.example.abstractemployee;

public class PartTime extends Employee {
    double wage;
    double hours;

    public PartTime(String name, double wage, double hours) {
        super(name, EmployeeType.PART_TIME);
        this.wage = wage;
        this.hours = hours;
    }

    @Override
    double calculateSalary() {
        return wage * hours;
    }
}
