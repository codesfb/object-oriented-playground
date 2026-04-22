import Employee.Employee;
import Employee.FullTimeEmployee;
import Employee.PerHourEmployee;
import java.time.LocalDate;
import Employee.Repository;
import Employee.FakeEmployeeRepository;
import Employee.RegisterEmployeeService;
import Employee.FindEmployeeService;

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
        //Repository tests
        Repository<Employee, String> repo = new FakeEmployeeRepository();
        RegisterEmployeeService registerService = new RegisterEmployeeService(repo);
        FindEmployeeService findService = new FindEmployeeService(repo);

        for (Employee e : funcionarios) {
            boolean cadastrou = registerService.register(e);
            if (cadastrou) {
                System.out.println("Funcionário registrado com sucesso!");
            } else {
                System.out.println("Aviso: Funcionário já existe no sistema.");
            }

        }


        Employee buscado = findService.findById("123");
        if (buscado != null) {
            System.out.println("Encontrado: " + buscado.getName());
        } else {
            System.out.println("Erro: Funcionário não localizado.");
        }
}




