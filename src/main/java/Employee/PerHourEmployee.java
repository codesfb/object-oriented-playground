package Employee;
import java.time.LocalDate;
import java.util.Objects;

public final class PerHourEmployee extends Employee {
    private final double hourlyRate;
    private final int workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, int workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    public double salary() {
        return hourlyRate * workedHour;
    }

    @Override
    public String toString() {
        return
                "Per hour employee: " +
                super.toString() +
                "Hourly Rate: " + hourlyRate +
                "Worked Hour: "+ workedHour;

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerHourEmployee that = (PerHourEmployee) o;
        return Double.compare(hourlyRate, that.hourlyRate) == 0 && workedHour == that.workedHour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlyRate, workedHour);
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getWorkedHour() {
        return workedHour;
    }
}
