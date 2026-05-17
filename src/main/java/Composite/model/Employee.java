package Composite.model;

import java.time.LocalDate;
import java.util.Objects;

public abstract  sealed  class Employee permits Consultant, Reseller {
    private final String id;
    private String name;
    private LocalDate birthDate;
    private double soldValue;




    public Employee(String id, String name, LocalDate birthDate, double soldValue ) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.soldValue = soldValue;
    }


    public abstract double getCommission();

    //[12312312312] David A. Huffman | Birthday: 1925-08-09 | Amount in sales: US$7000.00 | Commission: US$1272.73
    @Override
    public String toString() {
        return "[" + id +"] " + "|" +name+ "|Birthday: " + birthDate+ "|Amount in sales: " +soldValue+ "|Commission:"+ getCommission();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getSoldValue() {
        return soldValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSoldValue(double soldValue) {
        this.soldValue = soldValue;
    }


}
