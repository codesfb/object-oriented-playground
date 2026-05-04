package FunctionalPrograming.combinatorPattern;

import java.time.LocalDate;
import  FunctionalPrograming.combinatorPattern.CustomerRegistrationValidator;

import static FunctionalPrograming.combinatorPattern.CustomerRegistrationValidator.*;

public class MainCust {
    static void main() {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+92983223",
                LocalDate.of(2000, 1,1)
        );

        System.out.println(
                new CustomerValidatorService().isValid(customer));


        ValidatinonResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdut())
                .apply(customer);


        System.out.println(result);

        if(result != ValidatinonResult.SUCCESS){
            throw new IllegalArgumentException(result.name());
        }
    }
}
