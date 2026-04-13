import java.time.LocalDate;

public abstract sealed class Employee permits FullTimeEmployee, PerHourEmployee {
    private String id;
    private String name;
    private String jobTitle;
    private LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }



    public abstract double salary();


    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }

    public String getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
