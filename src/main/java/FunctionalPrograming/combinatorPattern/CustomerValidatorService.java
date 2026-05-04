package FunctionalPrograming.combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean  isEmailValid(String email){
        return email.contains("@");
    }
    private boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("+0");
    }
    private boolean isAdult(LocalDate birth){
       return  Period.between(birth, LocalDate.now()).getYears() >18;
    }
    public boolean isValid(Customer customer){
        return isEmailValid(customer.getEmail())&&
                isPhoneNumberValid(customer.getPhoneNumber())&&
                isAdult(customer.getDob());
    }
}
