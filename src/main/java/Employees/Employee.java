package main.java.Employees;

public class Employee {
    private String employeeId, name, jobTitle;
    private double salary;
    private int yearsOfService;

    public Employee() {
    } // default constructor

    public Employee(String employeeId, String name, double salary, String jobTitle, int yearsOfService) { // canonical constructor
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.yearsOfService = yearsOfService;
    }

    //TODO getters, setters para o que pode mudar, toString, equals e hashcode.
}