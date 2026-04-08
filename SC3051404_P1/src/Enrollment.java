import java.time.*;
import java.time.format.DateTimeFormatter;

public class Enrollment {

    private int id;
    private static int ids;
    private LocalDateTime enrollmentTime;
    private boolean concluded=false;
    private Course[]  diciplina = new Course[10];
    private int diciplinaCounter;

    private Student aluno;

    public void setAluno(Student aluno) {
        this.aluno = aluno;
    }


    public Enrollment( LocalDateTime enrollmentTime) {
        this.id = ids+1;
        this.enrollmentTime = enrollmentTime;

    }

    public int cargaTotalDiciplina(){
        int carga = 0;
        for (int i = 0; i < diciplinaCounter; i++) {

            carga+=diciplina[i].getWeeklyDurationInMinutes();
        }
        return carga /60;
    }


    public boolean enroll(Course course){
        if(course == null) return false;
        if(concluded) return false;

        for (int i = 0; i < diciplinaCounter; i++) {
            if(diciplina[i].getDayOfWeek() == course.getDayOfWeek()) return false;
        }

        if(cargaTotalDiciplina() > 22 ) return false;
        
        diciplina[diciplinaCounter++] = course;
        return true;
    }


    public void remove(Course course){
        if(concluded) return;

        for (int i = 0; i < diciplinaCounter; i++) {
            if(diciplina[i].equals(course)){
                for (int j = i; j < diciplinaCounter-1 ; j++) {
                    diciplina[j] = diciplina[j+1];
                }

            }
        }
        diciplina[--diciplinaCounter]= null;
        return;
    }

    public void conclude(){

          concluded= true;
          enrollmentTime = LocalDateTime.now();

    }

    public String getStateAsString(){
        DateTimeFormatter f =  DateTimeFormatter.ofPattern("dd/MM/yyyy hh/mm/ss");
        if(!concluded) return "Enrollment not concluded!";

        if(diciplina == null) return "Invalid enrollment!";
        return String.format("Enrollment Time: %s\n",enrollmentTime.format(f));
    }

    public String pontuacaoTotal( ){
        if(diciplinaCounter == 0) return "Nenhuma diciplina adicionada";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diciplinaCounter; i++) {

            sb.append(diciplina[i].getStateAsStringString()).append("\n");
        }
        return sb.toString();

    }


    @Override
    public String toString() {
        return "Enrollment{" +
                "id=" + id +
                ", enrollmentTime=" + enrollmentTime +
                ", concluded=" + concluded +
                '}';
    }

    public int getId() {
        return id= ids;
    }

    public LocalDateTime getEnrollmentTime() {
        return enrollmentTime;
    }

    public boolean isConcluded() {
        return concluded;
    }


}
