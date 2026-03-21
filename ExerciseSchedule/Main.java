import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalTime workStart = LocalTime.of(9, 0);  // 9:00 AM
        LocalTime workEnd = LocalTime.of(17, 0);   // 5:00 PM

        Schedule myDay = new Schedule(today, workStart, workEnd);


        Meeting morningStandup = new Meeting("Marketing", LocalTime.of(9, 30), LocalTime.of(10, 0));
        Meeting lunch = new Meeting("Lunch Break", LocalTime.of(12, 0), LocalTime.of(13, 0));
        Meeting overlapMeeting = new Meeting("Conflict", LocalTime.of(9, 45), LocalTime.of(10, 30));


        myDay.addMeeting(morningStandup); // Should succeed
        myDay.addMeeting(lunch);          // Should succeed
        myDay.addMeeting(overlapMeeting); // Should  "Overlap"


        System.out.println(myDay.scheduleAsString());
        System.out.println("Percentage busy: " + myDay.percentageSpentInMeetings() + "%");
    }
}