import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Enrollment {
    private static int nextId =1;
    private int id;
    private static int ids;
    private LocalDateTime enrollmentTime;
    private boolean concluded=false;
    private final Course[] diciplina = new Course[10];
    private int diciplinaCounter;
    private  Student student;

    public Enrollment( Student student) {
        this.id = nextId++;
        if(student == null && student.getId().equals("SC0000000")) {
            this.student = student;
            this.concluded= true;
        }else {
            this.student = student;
        }

    }



    public boolean enroll(Course newCourse){
        if (concluded || newCourse == null) return false;

        //colisão de horarios de vdd
        for (int i = 0; i < diciplinaCounter; i++) {
            Course c = diciplina[i];
            if (c.getDayOfWeek() == newCourse.getDayOfWeek()) {

                if (newCourse.getStartTime().isBefore(c.getEndTime()) &&
                        newCourse.getEndTime().isAfter(c.getStartTime())) {
                    return false;
                }
            }
        }
        int currentMinutes = 0;
        for (int i = 0; i < diciplinaCounter; i++) currentMinutes += diciplina[i].getWeeklyDurationInMinutes();
        if (currentMinutes + newCourse.getWeeklyDurationInMinutes() > 22 * 60) return false;
        diciplina[diciplinaCounter++] = newCourse;
        return true;
    }


    public void remove(Course course){
        if(concluded) return;

        for (int i = 0; i < diciplinaCounter-1; i++) {
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
        if (!concluded) {
            this.concluded = true;
            this.enrollmentTime = LocalDateTime.now();
        }
    }

    public String getStateAsString() {
        if (student == null || student.getId().equals("SC0000000")) return "Invalid enrollment!";
        if (!concluded) return "Enrollment not concluded!";

        StringBuilder sb = new StringBuilder();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        sb.append(student.getStateAsString()).append("\n");
        sb.append("Enrollment Time: ").append(enrollmentTime.format(dtf)).append("\n");
        sb.append("Courses:\n");
        for (int i = 0; i < diciplinaCounter; i++) {
            sb.append(diciplina[i].getStateAsString()).append("\n");
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
