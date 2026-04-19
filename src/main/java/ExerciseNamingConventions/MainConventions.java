import ExerciseNamingConventions.Convention;
import ExerciseNamingConventions.NamingConventions;

public class MainConventions {
    public static void main(String[] args) {

        System.out.println("=== CONVERSION TESTS ===");

        String ex1 = NamingConventions.fromConstToVariable("MAX_SIZE");
        String ex2 = NamingConventions.fromConstToVariable("MAX_SIZE_DIFER_T");
        String ex3 = NamingConventions.fromConstToVariable("MAX");

        System.out.println("Original: MAX_SIZE -> " + ex1);           // maxSize
        System.out.println("Original: MAX_SIZE_DIFER_T -> " + ex2);    // maxSizeDiferT
        System.out.println("Original: MAX -> " + ex3);                // max

        System.out.println("\n--- Converting Back to Constant ---");
        System.out.println(ex1 + " -> " + NamingConventions.fromVariableToConst(ex1));
        System.out.println(ex2 + " -> " + NamingConventions.fromVariableToConst(ex2));
        System.out.println(ex3 + " -> " + NamingConventions.fromVariableToConst(ex3));

        System.out.println("\n=== VALIDATION TESTS ===");

        // Testing specific convention rules
        String testVar = "myVariable";
        String testClass = "MyClass";
        String testConst = "MY_CONSTANT";
        String falseConst = "MY_second_CONST";

        System.out.println("Is '" + testVar + "' a valid VARIABLE? " +
                NamingConventions.isFollowingConvention(testVar, Convention.VARIABLE));

        System.out.println("Is '" + testClass + "' a valid CLASS? " +
                NamingConventions.isFollowingConvention(testClass, Convention.CLASS));

        System.out.println("Is '123invalid' a valid identifier? " +
                NamingConventions.isValidJavaIdentifier("123invalid"));

        System.out.println("Is " + falseConst +  " a valid CLASS? " +
                NamingConventions.isFollowingConvention(falseConst, Convention.CONSTANT));
    }
}
