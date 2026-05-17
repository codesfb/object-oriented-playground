package Composite.service;

import Composite.model.Consultant;
import Composite.model.Employee;
import Composite.model.Reseller;
import Composite.persistence.Repository;

import java.time.LocalDate;

public class EmployeeRegistrationService {
    private final Repository<String, Employee> employeerRepo;
    public EmployeeRegistrationService(Repository<String, Employee> employeerRepo) {
        this.employeerRepo = employeerRepo;
    }
    //InMemoryEmployeeRepository newrepo = new InMemoryEmployeeRepository();
    public void register(String id, String name, LocalDate birthDate, double soldValue, String consultantInCharge){

        Employee novo = new Reseller(id, name, birthDate,soldValue);
        employeerRepo.save(novo);

        //promotion to consultant
        if(consultantInCharge!= null) {
            Employee chefe = employeerRepo.findById(consultantInCharge).orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
            Consultant consultant;
            if(chefe instanceof  Reseller){
                consultant = new Consultant(chefe.getId(), chefe.getName(), chefe.getBirthDate(), chefe.getSoldValue());
                employeerRepo.update(consultant);
            }else{
                consultant = (Consultant) chefe;
            }
            consultant.addEmployee(novo);

        }

    }
}
