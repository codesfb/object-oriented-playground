import java.util.regex.Pattern;
import java.util.Locale;

public class NamingConventions {
    private  Convention convention;

    //https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
    //https://blog.jetbrains.com/idea/2024/01/evolution-of-the-switch-construct-in-java-why-should-you-care/
    public  static boolean isFollowingConvention(String name,  Convention convention){
        if(!isValidJavaIdentifier(name)) return false;


        return switch (convention) {
            case VARIABLE, METHOD -> Pattern.matches("^[a-z][a-zA-Z0-9]*$", name);
            case CONSTANT -> Pattern.matches("^[A-Z][A-Z0-9_]*$", name);
            case CLASS -> Pattern.matches("^[A-Z][a-zA-Z0-9]*$", name);
        };
    }


    /*
    //character by character
    public static boolean isValidJavaIdentifier(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            return false;
        }

        char first = identifier.charAt(0);


        if (!((first >= 'a' && first <= 'z') ||
                (first >= 'A' && first <= 'Z') ||
                (first == '$') ||
                (first == '_'))) {
            return false;
        }


        for (int i = 1; i < identifier.length(); i++) {
            char c = identifier.charAt(i);

            boolean isLetter = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
            boolean isDigit = (c >= '0' && c <= '9');
            boolean isSpecial = (c == '$' || c == '_');

            if (!(isLetter || isDigit || isSpecial)) {
                return false;
            }
        }

        return true;
    }
    */

    //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html#isJavaIdentifierPart(char)

    public static boolean isValidJavaIdentifier(String identifier){
        if(identifier == null) return false;
        if(!Character.isJavaIdentifierPart(identifier.charAt(0))) return false;
        for (int i = 0; i < identifier.length(); i++) {
            if(!Character.isJavaIdentifierPart(identifier.charAt(i))) return false;

        }
        return true;
    }

    public static String fromConstToVariable(String word){
        word = word.toLowerCase();
        //StringBuilder sb = new StringBuilder(word); Should i try with ?
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == '_'){
                index = i;
                word = word.substring(0, index)
                        + Character.toUpperCase(word.charAt(index + 1))
                        + word.substring(index + 2); //don't know about that but kind works out


            }


        }

        return word;

    }

    public static String fromVariableToConst(String variable){
        StringBuilder sb = new StringBuilder(variable);
        for (int i = variable.length()-1; i > 0 ; i--) {
                if(Character.isUpperCase(sb.charAt(i))){
                    sb.insert(i,'_');

                }
        }
        return sb.toString().toUpperCase();
    }




}
