package FunctionalPrograming.combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static FunctionalPrograming.combinatorPattern.CustomerRegistrationValidator.*;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidatinonResult> {

    static CustomerRegistrationValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ? ValidatinonResult.SUCCESS :ValidatinonResult.EMAIL_NOT_VALID;
    }

    static CustomerRegistrationValidator isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+0") ? ValidatinonResult.SUCCESS :ValidatinonResult.PHONE_NUMBER_NOT_VALID;
    }
    static CustomerRegistrationValidator isAnAdut(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18?ValidatinonResult.SUCCESS:ValidatinonResult.IS_NOT_AN_ADULT;
    }


    default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidatinonResult result = this.apply(customer);

            return result.equals(ValidatinonResult.SUCCESS)  ? other.apply(customer): result;
        };
    }

    enum ValidatinonResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }
}
