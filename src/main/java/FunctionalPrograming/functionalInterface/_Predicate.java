package FunctionalPrograming.functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    static void main() {
        String phone1 = "16000000003";
        String phone2 = "18000000000";
        System.out.println(isPhoneNumberValid(phone1));
        System.out.println(isPhoneNumberValid(phone2));
        System.out.println(isPhoneNumberValidPredicate.test(phone1));
        System.out.println(isPhoneNumberValidPredicate.test(phone2));
        System.out.println( isPhoneNumberValidPredicate.and(have3).test(phone1));//false
        System.out.println( isPhoneNumberValidPredicate.or(have3).test(phone1));//true



    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber
            ->  phoneNumber.startsWith("16") && phoneNumber.length() ==11;
    static Predicate<String> have3 = Number
            ->  Number.equals("3");

    static Predicate<String> isPhoneNumberValidPredicateAndHave3 = isPhoneNumberValidPredicate.and(have3);

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("16") && phoneNumber.length() ==11;
    }

}
