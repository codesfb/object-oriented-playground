import Employee.Employee;
import Employee.FullTimeEmployee;
import Employee.PerHourEmployee;
import java.time.LocalDate;

void main(String[] args) {
        FullTimeEmployee f1 = new FullTimeEmployee("123", "Ana", "Dev", LocalDate.now(), 5000.0);
        PerHourEmployee f2 = new PerHourEmployee("456", "Beto", "Designer", LocalDate.now(), 50.0, 160);
        FullTimeEmployee f3 = new FullTimeEmployee("123", "Ana 2", "Dev Senior", LocalDate.now(), 7000.0);

        Employee[] funcionarios = {f1, f2, f3};
        System.out.println(f2);
        for (Employee e : funcionarios) {
            System.out.println("Id: " + e.getId() +" \nNome: " + e.getName());
            System.out.println("Job: " + e.getJobTitle());
            System.out.println("Contrado : " + e.getDateOfEmployment() );
            System.out.println("Salário calculado: " + e.salary());//:)legal
            System.out.println("========================================\n");

        }
        //Repository tests here soon
}

