package Employee;

import java.util.Arrays;

public class FakeEmployeeRepository implements Repository<Employee, String> {
    private Employee[] employees = new Employee[2]; // Começando pequeno para testar a expansão
    private int acc = 0;

    @Override
    public void save(Employee e) {
        if (acc == employees.length) {
            expandCapacity();
        }
        employees[acc] = e;
        acc++;
    }

    private void expandCapacity() {
        int newSize = employees.length * 2;
        Employee[] newArray = new Employee[newSize];
        for (int i = 0; i < employees.length; i++) {
            newArray[i] = employees[i];
        }
        this.employees = newArray;

    }

    @Override
    public Employee findById(String id) {
        for (int i = 0; i < acc; i++) {
            if (employees[i].getId().equals(id)) {
                return employees[i];
            }
        }
        return null;
    }
}