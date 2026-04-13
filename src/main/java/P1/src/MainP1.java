import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class MainP1 {
    public static void main(String[] args) {
        // 1. Criando o Estudante
        // Testando um ID válido seguindo o padrão SCDDDDDDW
        Student aluno = new Student("SC123456X", "Clara Silva", LocalDate.of(2023, 2, 10));
        System.out.println("Estudante: " + aluno.getStateAsString());
        System.out.println("Semestre atual: " + aluno.getSemester());
        System.out.println("---");

        // 2. Criando Disciplinas
        // Note que o ID de cada Course deve ser incremental automático
        Course poo = new Course(LocalTime.of(19, 0), LocalTime.of(22, 30), "POO", "3223", "Lucas Bueno", DayOfWeek.FRIDAY, Room.C106);
        Course bd1 = new Course(LocalTime.of(19, 0), LocalTime.of(22, 30), "BD1", "3224", "Carlão", DayOfWeek.MONDAY, Room.C102);

        // Disciplina para testar CONFLITO (mesmo dia e horário de POO)
        Course conflitoPoo = new Course(LocalTime.of(20, 0), LocalTime.of(21, 0), "Extra", "000", "Prof X", DayOfWeek.FRIDAY, Room.C104);


        Enrollment matricula = new Enrollment(aluno);


        System.out.println("Status Inicial: " + matricula.getStateAsString());


        System.out.println("Matriculando POO: " + matricula.enroll(poo)); // true
        System.out.println("Matriculando BD1: " + matricula.enroll(bd1)); // true

        System.out.println(" conflito de horário: " + matricula.enroll(conflitoPoo)); // shold be false

        matricula.remove(bd1);
        System.out.println("BD1 removida. Tentando matricular novamente...");
        System.out.println("Matriculando BD1 de novo: " + matricula.enroll(bd1));


        matricula.conclude();
        System.out.println("\n--- MATRÍCULA CONCLUÍDA ---");
        System.out.println(matricula.getStateAsString());


        //depois de concluido n adiciona mais
        Course nova = new Course(LocalTime.of(8,0), LocalTime.of(10,0), "Teste", "999", "Prof Y", DayOfWeek.TUESDAY, Room.C209);
        System.out.println("Tentando adicionar após concluir: " + matricula.enroll(nova)); // false
    }
}