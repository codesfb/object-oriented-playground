import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endingTime;

    //when to build with constructor  method ? and when not to ?
    public Meeting(String description, LocalTime startTime,LocalTime endingTime  ){
        this.description = description;
        this.startTime = startTime;
        this.endingTime = endingTime;

    }

    //in case i need
    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public String getDescription() {
        return description;
    }

    //TODO posicione métodos com implementação sua sempre antes dos getters, geralmente gerados pelo IDE.
    public long durationInMinutes(){
        return Duration.between(this.startTime, this.endingTime).toMinutes();//duration is an object thats why i need to convert
    }

}
