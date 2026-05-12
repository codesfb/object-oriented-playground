package class07;

//import Employee.Employee;

import java.time.LocalDate;
import java.util.*;

public class Company {

    static void main() {

        var ada = new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now());
        var dijkstra = new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2));
        var huffman = new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1));


        var comp = new Company();

        if (comp.hire(ada,dijkstra, huffman)) {
            System.out.println(" Contraado com sucesso");
        } else {
            System.out.println("Erro ao cotratar");
        }

        comp.getEmployees();
        //o my days who i will fire now?

        comp.fire("01");
        System.out.println(ada.getName() +  " fired");

        comp.getEmployees("Computer Scientist");
        System.out.println("Payment");
        System.out.println(comp.pay("01"));
        System.out.println(comp.pay("02"));
        System.out.println(comp.pay("03"));

        System.out.println("Increase salary");
        System.out.println("Hufman salary before " + huffman.getSalary());
        comp.increaseSalary("02",20_000.0);
        System.out.println("Hufman salary after " + huffman.getSalary());
        System.out.println("Average salary " + comp.averageSalary("Computer Scientist"));


    }

    Set<Employee> company = new LinkedHashSet<>();

    public boolean hire(Employee...employee){
        return Collections.addAll(this.company, employee);
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



}
