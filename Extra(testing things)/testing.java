import java.time.*;

public class testing {

    static void main() {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());


        final Instant plusBegin = Instant.now();
        String result = "";
        for (int i = 0; i < 100_000; i++)
            result += " " + i;
        final Instant plusEnd = Instant.now();
        final Instant builderBegin = Instant.now();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100_000; i++)
            builder.append(" ").append(i);
        String sbResult = builder.toString();
        final Instant builderEnd = Instant.now();
        System.out.println("With plus = " + Duration.between(plusBegin, plusEnd).toSeconds()); // 2660 milliseconds
        System.out.println("With builder = " + Duration.between(builderBegin, builderEnd).toSeconds()   ); // 13 milliseconds



    }
}
