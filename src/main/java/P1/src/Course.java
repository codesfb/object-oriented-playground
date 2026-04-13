import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Course {
    private  int id;
    private static int ids=1;
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;
    private String code;
    private String professor;
    private DayOfWeek dayOfWeek;
    private Room room;

    public Course( LocalTime startTime, LocalTime endTime, String name, String code, String professor, DayOfWeek dayOfWeek, Room room) {
        if(startTime != null && endTime != null && endTime.isAfter(startTime)) {
            this.id = ids++;
            this.startTime = startTime;
            this.endTime = endTime;
            this.name = name;
            this.code = code;
            this.professor = professor;
            this.dayOfWeek = dayOfWeek;
            this.room = room;
        }else{
            this.id = this.getId();
            this.startTime = LocalTime.MIDNIGHT;
            this.endTime = LocalTime.MIDNIGHT;
            this.name = "Invalid";
            this.code = "0";
            this.professor = "Professor invalido";
            this.dayOfWeek = DayOfWeek.MONDAY;
            this.room = Room.C102;
        }
    }

    public int getWeeklyDurationInMinutes(){
        return (int)Duration.between(startTime, endTime ).toMinutes();//resolvido parcialmente
    }
    public String getStateAsString(){
        return String.format("id=%d | %s | %s | Start=%s | End=%s %s | Room=%s |",
                id,name, dayOfWeek, startTime, endTime, professor, room);
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", professor='" + professor + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", room=" + room +
                '}';
    }


    public int getId() {
        return id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getProfessor() {
        return professor;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public Room getRoom() {
        return room;
    }
}
