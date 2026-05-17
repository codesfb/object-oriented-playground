package Composite.model;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public final class Consultant extends Employee {
    public Set<Employee> subordinates = new LinkedHashSet<>();//TODO learn better of witch i can use for each case
    public Consultant(String id, String name, LocalDate birthDate, double soldValue) {
        super(id, name, birthDate, soldValue);

    }

    @Override
    public double getCommission() {
        double comissaoSubordinados = subordinates.stream()
                .mapToDouble(Employee::getCommission)
                .sum();

        return (getSoldValue() * 0.15) + (comissaoSubordinados * 0.30);
    }

    public void addEmployee(Employee e){
        subordinates.add(e);

    }

    public Set<Employee> getEmployees(){
        return subordinates;
    }
}
