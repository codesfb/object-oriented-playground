import javax.print.attribute.standard.DateTimeAtCompleted;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Post {
    private String quote;
    private LocalDate date;
    private int claps;
    private int boos;
    private UserAccount user;

    public Post(UserAccount account,String quote) {
        this.quote = quote;
        this.user= account;
        this.date = LocalDate.now();

    }

    public Post(LocalDate date) {
        this.date = date;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public LocalDate getDate() {
        return date;
    }

    public int claps() {
        return claps++;
    }

    public int boos() {
        return boos++;
    }

    public String getQuote() {
        return quote;
    }


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format("[%s] %s says \"%s\" | Claps: %d | Boos: %d",
                formatter.format(date),
                user.getUserName(),
                quote,
                claps,
                boos
        );
    }
    public UserAccount getAccount() {
        return user;
    }

}