package main.java.ExerciseSchedule;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endingTime;
    private int scheduleIndex;

    // TODO use arrays, pois não será permitido usar listas na p1.//DONE
    //private List<Meeting> schedule;
    private Meeting[] schedule;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endingTime) {
        this.day = day;
        this.startTime = startTime;
        this.endingTime = endingTime;
        this.schedule = new Meeting[30];
    }


    //can i do that the func end up with two resposabilitys though

    // TODO evite fazer I/O em classes de negócio (não main ou dedicadas a CLI)//done
    //TODO there is better way of doin this is creating Nested class operation resuld type record
    //sounds cleaner  public record OperationResult(boolean success, String message) {}
    public String addMeeting(Meeting newMeeting) {
        if (newMeeting == null) return "Empty meeting";
        if (isOutsideSchedule(newMeeting)) return isOutsideScreduletoString(newMeeting);
        if (isConflitMeeting(newMeeting)) return isOutsideScreduletoString(newMeeting);
        if (isMeetingInschedule(newMeeting)) return isOutsideScreduletoString(newMeeting);
        this.schedule[scheduleIndex++] = newMeeting;
        return "Meeting "+ newMeeting.getDescription() + " Added sucessefuly";
    }

    public boolean isConflitMeeting(Meeting Meeting) {
        for (int i = 0; i < scheduleIndex; i++) {
            if (Meeting.getStartTime().isBefore(schedule[i].getEndingTime()) &&
                Meeting.getEndingTime().isAfter(schedule[i].getStartTime())) {
                return true;
                }
        }
        return false;
    }

    public boolean isOutsideSchedule(Meeting Meeting) {
        return Meeting.getStartTime().isBefore(this.startTime) ||
                Meeting.getEndingTime().isAfter(this.endingTime);
    }

    public String isOutsideScreduletoString(Meeting meeting){
        if(isMeetingInschedule(meeting))return "Meeting" + meeting.getDescription() + " aready in the schedule";
        if(isOutsideSchedule(meeting)) return  "Meeting " + meeting.getDescription() + " outside schedule";
        if (isConflitMeeting(meeting)) return "Meeeting " + meeting.getDescription() + " is confliting";
        return  "Meeting " + meeting.getDescription() + " can be added to the schedule";
    }

    public boolean isMeetingInschedule(Meeting meeting){
        for (int i = 0; i < scheduleIndex; i++) {
            if(meeting.equals(schedule[i])) return true;
        }
        return false;
    }


    public void removeMeeting(Meeting meeting) {
        int meetingIndex;
        for (int i = 0; i < scheduleIndex; i++) {
            if(meeting.equals(schedule[i])) {
                meetingIndex = i;
                //schedule[meetingIndex]= null;
                for (int j = i; j < scheduleIndex -1; j++) {
                    schedule[j]= schedule[j+1];
                }

            }
            schedule[--scheduleIndex]=null;
            return;
        }

    } // TODO faça com array, com lógica para limpar a posição na qual estada o elemento.//Done

    public long scheduleDurationInMinutes() {
        return Duration.between(this.startTime, this.endingTime).toMinutes();
    }

    public double percentageSpentInMeetings() {
        long accMeetingsMinutes = 0;
        for (int i = 0; i < scheduleIndex; i++) {
            accMeetingsMinutes+= schedule[i].durationInMinutes();
        }
        //double totalWorkdayMins = scheduleDurationInMinutes();
        // TODO você pode dar inline do método aqui, já que ele deveria ser interno (utilitário)//Done

        return (accMeetingsMinutes / (double)scheduleDurationInMinutes()) * 100;
    }




    public String scheduleAsString() {
        StringBuilder s = new StringBuilder();
        s.append("Schedule for: ").append(day).append("\n");
        s.append("Hours: ").append(startTime).append(" - ").append(endingTime).append("\n");
        s.append("---------------------------\n");
        s.append("All your meetings\n");
        for (int i = 0; i < scheduleIndex; i++) {
            s.append("Description: ").append(schedule[i].getDescription()).append(" Duration: ").append(schedule[i].durationInMinutes()).append(" minutes\n");
        }

        return s.toString();
    }
}