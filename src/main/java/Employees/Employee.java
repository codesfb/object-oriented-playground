package main.java.Employees;

public class Employee {
    String employeeId, name, jobTitle;
    double salary;
    int yearsOfService;

    public Employee() {
    } // default constructor

    public Employee(String employeeId, String name, double salary, String jobTitle, int yearsOfService) { // canonical constructor
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.yearsOfService = yearsOfService;


    }
}