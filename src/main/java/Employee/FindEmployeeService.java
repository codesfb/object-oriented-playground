package Employee;

public class FindEmployeeService{
    private final Repository<Employee, String> repository;
    public FindEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }
    public Employee findById(String id){
            Employee employee = repository.findById(id);
            if(employee!=null) return employee;
            else return null;
    }
}
