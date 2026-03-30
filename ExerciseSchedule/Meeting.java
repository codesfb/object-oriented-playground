import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endingTime;


    public Meeting(String description, LocalTime startTime,LocalTime endingTime  ){
        this.description = description;
        this.startTime = startTime;
        this.endingTime = endingTime;

    }
    //TODO posicione métodos com implementação sua sempre antes dos getters, geralmente gerados pelo IDE.//done

    public long durationInMinutes(){
        return Duration.between(this.startTime, this.endingTime).toMinutes();
    }


    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public String getDescription() {
        return description;
    }



}
