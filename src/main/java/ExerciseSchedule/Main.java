package main.java.ExerciseSchedule;

import java.time.LocalDate;
import java.time.LocalTime;


//TODO GERAL: a implementação está no caminho certo, com mínimos detalhes para arrumar. Você já tem alguma experiência
// anterior com programação OO?
public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalTime workStart = LocalTime.of(9, 0);  // 9:00 AM
        LocalTime workEnd = LocalTime.of(17, 0);   // 5:00 PM

        Schedule myDay = new Schedule(today, workStart, workEnd);

        Meeting morningStandup = new Meeting("Marketing", LocalTime.of(9, 0), LocalTime.of(10, 0));
        Meeting lunch = new Meeting("Lunch Break", LocalTime.of(12, 0), LocalTime.of(13, 0));
        Meeting overlapMeeting = new Meeting("Conflict", LocalTime.of(9, 45), LocalTime.of(10, 30));


        System.out.println(myDay.addMeeting(morningStandup)); // Should succeed
        myDay.addMeeting(lunch);          // Should succeed
        myDay.addMeeting(overlapMeeting); // Should  "Overlap"


        //TODO está bom, mas na prova detalhe mais, mostrando sobreposição no início, no fim, sobre, dentro.//done
        Meeting after13Meeting = new Meeting("Busines", LocalTime.of(13, 0), LocalTime.of(14, 30));
        myDay.addMeeting(after13Meeting);
        Meeting after13MeetingOverlap = new Meeting("Busines2", LocalTime.of(13, 30), LocalTime.of(14, 0));
        myDay.addMeeting(after13MeetingOverlap);

        Meeting metingFrom16to17 = new Meeting("16 to 17", LocalTime.of(16, 0), LocalTime.of(17, 0));
        Meeting afterEnd = new Meeting("afterEnd", LocalTime.of(17, 0), LocalTime.of(18, 0));
        Meeting beforebegin = new Meeting("beforebegin", LocalTime.of(8, 0), LocalTime.of(9, 0));
        Meeting alltime = new Meeting("meeting that take all the time available", LocalTime.of(9, 0), LocalTime.of(17, 0));

        System.out.println(myDay.addMeeting(metingFrom16to17));
        System.out.println(myDay.addMeeting(afterEnd));
        System.out.println(myDay.addMeeting(beforebegin));
        System.out.println(myDay.addMeeting(alltime));

        //TODO faça também testes para limites do dia de trabalho//done

        System.out.println(myDay.scheduleAsString());
        System.out.println( myDay.isOutsideScreduletoString(morningStandup));
        System.out.println( myDay.isOutsideScreduletoString(overlapMeeting));


        System.out.println("Percentage busy: " + myDay.percentageSpentInMeetings() + "%");
    }
}