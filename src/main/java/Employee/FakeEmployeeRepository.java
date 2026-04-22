package Employee;

public class FakeEmployeeRepository implements Repository<Employee, String>{
    Employee[] employees = new Employee[20];
    int acc =0;

    @Override
    public void save(Employee e) {
        employees[acc]=e;
    }

    @Override
    public Employee findById(String id) {
        for(Employee e: employees){
            if(e.getId().equals(id))
                return e;

        }
        return null;
    }
}
