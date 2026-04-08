import java.time.*;

public class Course {
    private  int id;
    private static int ids;
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;
    private String code;
    private String professor;
    private DayOfWeek dayOfWeek;
    private Room room;

    public Course( LocalTime startTime, LocalTime endTime, String name, String code, String professor, DayOfWeek dayOfWeek, Room room) {
        this.id = this.getId();
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.code = code;
        this.professor = professor;
        this.dayOfWeek = dayOfWeek;
        this.room = room;
    }

    //Não me lembro como verifica se o valor é valido volto depis;

    public int getWeeklyDurationInMinutes(){
        return (int)Duration.between(startTime, endTime ).toMinutes();//resolvido parcialmente
    }

//    id = 1 | Object-orientation (POO) | FRIDAY | Start = 19:00 | End = 22:30 | Lucas Bueno | Room = C106 |

    public String getStateAsStringString(){
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
        return ids++;
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
