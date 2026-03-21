import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endingTime;
    private List<Meeting> schedule;

    public Schedule(LocalDate day,
                    LocalTime startTime,
                    LocalTime endingTime) {
        this.day = day;
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.schedule = new ArrayList<>();
    }

    public void addMeeting(Meeting newMeeting) {
        if(newMeeting == null) return;

//        if(newMeeting.durationInMinutes() >
//                Duration.between(this.startTime, this.endingTime).toMinutes() )
//            return;


        if(newMeeting.getStartTime().isBefore(this.startTime) ||
        newMeeting.getEndingTime().isAfter(this.endingTime)) {
            System.out.println("Outide schedule");
            return;
        }

        for(Meeting m: schedule){
            if (newMeeting.getStartTime().isBefore(m.getEndingTime()) &&
                    newMeeting.getEndingTime().isAfter(m.getStartTime())) {
                System.out.println("Overlap");
                return;
            }
        }
        this.schedule.add(newMeeting);
        System.out.println("new meeting added");

    }

    public void removeMeeting(Meeting meeting) {
        schedule.remove(meeting);
    }


    public long scheduleDurationInMinutes(){
        return Duration.between(this.startTime, this.endingTime).toMinutes();//duration is an object thats why i need to convert
    }

    public double percentageSpentInMeetings() {
        long accMeetingsMinutes =0;
        for(Meeting m: schedule){
            accMeetingsMinutes+=m.durationInMinutes();
        }
        double totalWorkdayMins= scheduleDurationInMinutes();

        return (accMeetingsMinutes / totalWorkdayMins  ) * 100;
    }

    public String scheduleAsString() {
        StringBuilder s = new StringBuilder();
        s.append("Schedule for: ").append(day).append("\n");
        s.append("Hours: ").append(startTime).append(" - ").append(endingTime).append("\n");
        s.append("---------------------------\n");
        for(Meeting m: schedule){
            s.append("Description: ").append(m.getDescription()).append(" Duration: ").append( m.durationInMinutes()).append(" minutes\n");
        }

        return s.toString();
    }
}