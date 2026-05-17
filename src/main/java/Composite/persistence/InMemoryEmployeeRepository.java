package Composite.persistence;

import Composite.excepetion.EntityAlreadyExistsException;
import Composite.model.Consultant;
import Composite.model.Employee;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryEmployeeRepository implements Repository<String, Employee>{
    Map<String, Employee> repository = new LinkedHashMap<String, Employee>();

    @Override
    public void save(Employee obj) {
        if(repository.containsKey(obj.getId()))
            throw new EntityAlreadyExistsException("Employee aready exists");

        repository.put(obj.getId(), obj);
    }

    @Override
    public void update(Employee obj) {
        Employee old = repository.get(obj.getId()); // referência antiga
        repository.replace(obj.getId(), obj);

        // Atualiza a referência em todos os consultores que tinham o objeto antigo
        for (Employee e : repository.values()) {
            if (e instanceof Consultant c && c.subordinates.remove(old)) {
                c.subordinates.add(obj); // substitui pelo novo objeto
            }
        }
    }
    @Override
    public Optional<Employee> findById(String value) {
            return Optional.ofNullable(repository.get(value));
        }
    }


