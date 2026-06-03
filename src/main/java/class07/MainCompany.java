import class07.Company;
import class07.Employee;

import java.sql.SQLException;

void main() throws SQLException {

    var adaL = new Employee("01", "Ada Lovelace", "Computer Programmer", 10_000.0, LocalDate.now());
    var dijkstra = new Employee("03", "Edsger Dijkstra", "Computer Scientist", 10_400.0, LocalDate.now().minusYears(2));
    var huffman = new Employee("02", "David Huffman", "Computer Scientist", 10_700.0, LocalDate.now().minusYears(1));


    var comp = new Company();

    if (comp.hire(adaL,dijkstra, huffman))
        System.out.println("Contraado com sucesso");



    System.out.println();
    comp.getEmployees();


    comp.fire("01");
    System.out.println(adaL.getName() +  " fired");

    comp.getEmployees("Computer Scientist");
    System.out.println("Payment");
    System.out.println(comp.pay("01"));
    System.out.println(comp.pay("02"));
    System.out.println(comp.pay("03"));

    System.out.println("Increase salary");
    System.out.println("Hufman salary before " + huffman.getSalary());
    comp.increaseSalary("02",20_000.0);
    System.out.println("Hufman salary after " + huffman.getSalary());
    System.out.println("Average salary " + comp.averageSalary("Computer Scientist"));


}