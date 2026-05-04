package Employee;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Company {

    static void main() {

    }

    Set<Employee> company = new LinkedHashSet<>();

    public void hire(Employee employee){
        company.add(employee);
    }

    public void fire(String id){
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

//    public void pay(String id){

//
//    }num sei
    public void increaseSalary(String id, double newSalary){
        company.stream()
                .filter(e -> e.getJobTitle().equals(id))
                .findFirst()
                .ifPresent(e->
                {
                    if(e instanceof FullTimeEmployee e2){
                        e2.setMonthlySalary(newSalary);
                    }
                });

    }

    public double averageSalary(String jobTitle){
       return company.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .mapToDouble(Employee::salary)
                .average().orElse(0.0);


    }
    public double averageSalary(LocalDate inicio, LocalDate fim){
        return company.stream()
                .filter(e -> e.getDateOfEmployment().isAfter(inicio)&&
                        e.getDateOfEmployment().isBefore(fim) )
                .mapToDouble(Employee::salary)
                .average().orElse(0.0);


    }



}
