package Employee;

public class RegisterEmployeeService {
    private final Repository<Employee, String> repository;

    public RegisterEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public void register(Employee e){
        if(repository.findById(e.getId())==null){
            repository.save(e);
        }else return;

    }

}
