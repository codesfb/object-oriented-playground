import java.time.*;
import java.time.format.DateTimeFormatter;

public class MainGDPP {
    static void main() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        LocalDate hireDate = LocalDate.parse("01/01/2020", formatter);
        LocalDate birthDate = LocalDate.parse("29/01/2000",formatter);

        Employee e1 = new Employee("Duck", birthDate, hireDate);
        System.out.println(e1.getAgeInYears());
        System.out.println(e1.getYearsOfService());
        WorkShift turno = WorkShift.of(LocalDate.of(2026,2,9), LocalTime.of(8,00), LocalTime.of(16,00));
        turno.doCheckIn(LocalDateTime.now());
        turno.doCheckOut(LocalDateTime.now().plusHours(8));

        System.out.println(turno.getFormattedShiftReport());



    }
}