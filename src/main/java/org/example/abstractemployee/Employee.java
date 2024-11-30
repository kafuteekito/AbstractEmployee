package org.example.abstractemployee;

public abstract class Employee {
    protected String name;
    protected EmployeeType type;
    protected Double salary;

    public Employee(String name, EmployeeType type, double salary) {
        this.name = name;
        this.type = type;
        this.salary = salary;
    }

    public Employee(String name, EmployeeType type) {
        this.name = name;
        this.type = type;
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    abstract double calculateSalary();
}
