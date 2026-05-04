package FunctionalPrograming.Optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class MainOp {
    static void main() {
        Object value = Optional.ofNullable(null)
                .orElse("default");
                //the same as () -> "default"
        System.out.println(value);
        /*
        Supplier<IllegalArgumentException> exception = () -> new IllegalArgumentException("Exception");
        Object value2= Optional.ofNullable(null)
                .orElseThrow(exception);
        */

        Optional.ofNullable(null)
                .ifPresentOrElse(
                 email-> System.out.println("Sending email to " + email),
                        ()-> System.out.println("Cannot send email")
                );
        //System.out.println(value2);

    }


}
