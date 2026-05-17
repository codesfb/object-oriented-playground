import Composite.model.Employee;
import Composite.persistence.InMemoryEmployeeRepository;
import Composite.persistence.Repository;
import Composite.service.EmployeeRegistrationService;
import Composite.service.EmployeeReportService;

void main(){
    Repository<String, Employee> repository = new InMemoryEmployeeRepository();
    EmployeeRegistrationService employeeRegistrationService = new EmployeeRegistrationService(repository);
    EmployeeReportService reportService = new EmployeeReportService(repository);
    employeeRegistrationService.register("12312312312",
            "David A. Huffman",
            LocalDate.parse("1925-08-09"),
            7000.0,
            null);

    employeeRegistrationService.register("32132132131",
            "Augusta Ada Byron",
            LocalDate.parse("1852-11-27"),
            3000.0,
            "12312312312");

    employeeRegistrationService.register("21321321313",
            "Edsger Wybe Dijkstra",
            LocalDate.parse("1930-05-11"),
            1520.0,
            "12312312312");
    employeeRegistrationService.register("45645645646",
            "Alan Mathison Turing",
            LocalDate.parse("1912-06-23"),
            780.0,
            "32132132131");
    employeeRegistrationService.register("90219021902",
            "Donald Ervin Knuth",
            LocalDate.parse("1938-01-10"),
            432.0,
            "45645645646");
    employeeRegistrationService.register("54654654654",
            "Grace Murray Hopper",
             LocalDate.parse("1906-12-09"),
            432.0,
            "21321321313");
    employeeRegistrationService.register("65465465464",
            "John von Neumann",
            LocalDate.parse("1903-12-28"),
            300.0,
            "45645645646");


    reportService.reportOf("12312312312");




}