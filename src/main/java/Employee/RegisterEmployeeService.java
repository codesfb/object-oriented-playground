package Employee;

public class RegisterEmployeeService {
    private final Repository<Employee, String> repository;

    public RegisterEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public boolean register(Employee e){
        if(repository.findById(e.getId()) == null){
            repository.save(e);
            return true; // Sucesso
        }
        return false; // Não salvou porque já existia
    }

}
