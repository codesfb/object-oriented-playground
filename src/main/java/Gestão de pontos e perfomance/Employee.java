import javax.swing.text.DateFormatter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Employee {
    private String name;
    private LocalDate birthDate;
    private LocalDate hireDate;

    public Employee(String name, LocalDate birthDate, LocalDate hireDate) {

        this.name = name;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
    }

    //ariscando um factory do nada pq aprendi hoje huehue
    public static Employee of(String name, LocalDate birthDate, LocalDate hireDate){
        if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser no futuro!");
        }
        return new Employee(name,birthDate, hireDate);
    }


    public int getAgeInYears(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
    public int getYearsOfService(){
        return Period.between(hireDate, LocalDate.now()).getYears();

    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }
}
