import Employee.Employee;
import Employee.FullTimeEmployee;
import Employee.PerHourEmployee;
import Lambda.RH.CriterioFiltro;
import Lambda.RH.RHService;

void main(String[] args){
    FullTimeEmployee f1 = new FullTimeEmployee("100", "Duck", "Dev", LocalDate.now(), 5000.0);
    FullTimeEmployee f2 = new FullTimeEmployee("101", "Beto", "Designer", LocalDate.now(), 10000);
    FullTimeEmployee f3 = new FullTimeEmployee("102", "Alfredo", "Dev Senior", LocalDate.now(), 7000.0);

    Employee[] funcionarios = {f1, f2, f3};
    System.out.println("--- Funcionários com salário > 5000 ---");
    RHService.filtro(funcionarios, (e) -> e.salary() > 5000 );
    System.out.println("\n--- Funcionários que começam com 'A' ---");
    RHService.filtro(funcionarios, (e) -> e.getName().startsWith("A"));



}