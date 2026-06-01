package class07;

//import Employee.Employee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Company {



    Set<Employee> company = new LinkedHashSet<>();

    public boolean hire(Employee...employee) throws SQLException {
        if(employee == null) throw new IllegalArgumentException("O funcionario não pode ser nulo");
        if(employee.length ==0) return false;
        for (Employee employee1 : employee) {
            if(employee1==null){
                throw new IllegalArgumentException("Um dos funcionarios esta nulo");
            }

        }

        save(employee);
        return Collections.addAll(this.company, employee);
    }

    public void fire(String id){
            if(id.isEmpty()) throw new IllegalArgumentException("id vazio, not possible to fire emplyee");
            company.removeIf(e -> e.getId().equals(id));
    }

    public void getEmployees(){
        company.forEach(System.out::println);
    }

    public void getEmployees(String jobTitle){
        company.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .forEach(System.out::println);
    }

    public boolean pay(String id){
        return company.stream()
                .filter(employee -> id.equals(employee.getId()))
                .anyMatch(employee -> employee.createPaycheck(LocalDate.now()));

     }
    public void increaseSalary(String id, double newSalary){
        company.stream()
                .filter(e -> id.equals(e.getId()))
                .findFirst()
                .ifPresent(e->
                    e.setSalary(newSalary)
                );
    }

    public double averageSalary(String jobTitle){
       return company.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::getSalary)
                .average().orElse(0.0);


    }
    public double averageSalary(LocalDate inicio, LocalDate fim){
        return company.stream()
                .filter(e -> e.getDateOfEmployment().isAfter(inicio)&&
                        e.getDateOfEmployment().isBefore(fim) )
                .mapToDouble(Employee::getSalary)
                .average().orElse(0.0);


    }


    public static void save(Employee...employee) throws SQLException{

        String sql = "INSERT INTO employees (id, name, jobTitle, salary, dateOfEmployment,skills) VALUES (?, ?, ?, ?, ?,?)";
        try (final Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
             final PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Employee employee1 : employee) {


                statement.setString(1, employee1.getId());
                statement.setString(2, employee1.getName());
                statement.setString(3, employee1.getJobTitle());
                statement.setDouble(4, employee1.getSalary());
                statement.setString(5, employee1.getDateOfEmployment().toString());
                String skills = employee1.getSkills().toString();
                statement.setString(6, skills);

            }

            statement.executeUpdate(); // executes the statement
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

    }



