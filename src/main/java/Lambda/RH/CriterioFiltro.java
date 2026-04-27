package Lambda.RH;
import Employee.Employee;
@FunctionalInterface
public interface CriterioFiltro {
    boolean testar(Employee e);
}
