package org.example.abstractemployee;

public class Contractor extends Employee {
    double rate;
    double hours;
    private static final double MaxHours = 160.0;

    public Contractor(String name, double rate, double hours) {
        super(name, EmployeeType.CONTRACTOR);
        this.rate = rate;
        this.hours = hours;
    }

    @Override
    double calculateSalary()
    {
        double billHours = Math.min(hours, MaxHours);
        return rate * billHours;
    }
}
