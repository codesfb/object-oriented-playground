package Employee;
import java.time.LocalDate;
import java.util.Objects;


public final class FullTimeEmployee extends Employee {
    final private double monthlySalary;

    public FullTimeEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double monthlySalary) {
        super(id, name, jobTitle, dateOfEmployment);
        this.monthlySalary = monthlySalary;
    }

    //Não tem bonus nem desconto então ficaria assim mesmo basicamente um get?
    @Override
    public double salary() {
        return monthlySalary;
    }


    @Override
    public String toString() {
        return "Employee= " + super.toString() +
                "monthlySalary=" + monthlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FullTimeEmployee that = (FullTimeEmployee) o;
        return Double.compare(monthlySalary, that.monthlySalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), monthlySalary);
    }
}
