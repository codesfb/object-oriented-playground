package FunctionalPrograming.Imperative.functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    static void main() {
        String phone1 = "16000000000";
        String phone2 = "18000000000";
        System.out.println(isPhoneNumberValid(phone1));
        System.out.println(isPhoneNumberValid(phone2));
        System.out.println(isPhoneNumberValidPredicate.test(phone1));
        System.out.println(isPhoneNumberValidPredicate.test(phone2));



    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber
            ->  phoneNumber.startsWith("16") && phoneNumber.length() ==11;
    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("16") && phoneNumber.length() ==11;
    }

}
