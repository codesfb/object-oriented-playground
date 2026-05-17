package Composite.service;
import Composite.model.Consultant;
import Composite.model.Employee;
import Composite.persistence.Repository;

public class EmployeeReportService {
    private final Repository<String, Employee> employeerRepo;

    public EmployeeReportService(Repository<String, Employee> employeerRepo) {
        this.employeerRepo = employeerRepo;
    }

    public void reportOf(String id) {
        employeerRepo.findById(id).ifPresent(e -> printRecursive(e, 0));
    }

    private void printRecursive(Employee e, int level) {
        //  para mostrar a hierarquia
        String indent = "  ".repeat(level);
        System.out.println(indent + e.toString());

        if (e instanceof Consultant c) {
            for (Employee sub : c.getEmployees()) {
                printRecursive(sub, level + 1); // Chama para o próximo nível
            }
        }
    }
}