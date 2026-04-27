package Lambda.RH;

import Employee.Employee;

public class RHService {
    public static void filtro(Employee[] lista, CriterioFiltro filtro){
        for(Employee e: lista){
            if(filtro.testar(e)){
                System.out.println(e.getName() + " " + e.getJobTitle()   + " " + e.salary());
            }
        }

    }


}
