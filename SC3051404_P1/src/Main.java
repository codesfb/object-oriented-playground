import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Student aluno1 = new Student("SC333333X","Jhon" , LocalDate.of(2024, 1,13 ));

        System.out.println(aluno1.getStateAsString());
//
//
        LocalDate dia = LocalDate.of(2027,1,13);
        LocalTime hora = LocalTime.of(8,0);
        LocalDateTime time = LocalDateTime.of(dia, hora);

        Course poo = new Course(LocalTime.of(19,0), LocalTime.of(22,0), "Object-orientation (POO)","3223"," Lucas Bueno", DayOfWeek.FRIDAY, Room.C106 );
        Course BD = new Course(LocalTime.of(14,0), LocalTime.of(15,0), "Databases I (BD1)","3223"," Carlão", DayOfWeek.MONDAY, Room.C102 );
        Course BD2 = new Course(LocalTime.of(16,0), LocalTime.of(20,0), "Databases II (BD2)","3223"," Carlão", DayOfWeek.TUESDAY, Room.C107 );

        Enrollment curso = new Enrollment(time);
        curso.setAluno(aluno1);
        curso.enroll(poo);
        curso.enroll(BD);
        curso.enroll(BD2);
//        System.out.println(curso.getStateAsString());
//        //ele parece n estar adcionando todos s cursos do aluno
//        System.out.println("POO é cursada " + poo.getDayOfWeek());
//        curso.enroll(BD);
//        curso.conclude();
//
//        System.out.println(curso.getStateAsString());
//
//        System.out.println(curso.cargaTotalDiciplina());
        System.out.println(curso.pontuacaoTotal());

    }
}