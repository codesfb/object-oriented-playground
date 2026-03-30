
public class validEmail {
    //TODO dá para melhorar isso aqui de acordo com as regras de criação de e-mails válidos //done

    public static boolean betterIsValidmail(String email) {
        // 1. Basic length and null checks
        if (email == null || email.length() > 254 || email.isEmpty()) return false;
        if (email.startsWith(".") || email.endsWith(".")) return false;

        // 2. Check for the @ symbol correctly
        int firstArroba = email.indexOf('@');
        int lastArroba = email.lastIndexOf('@');
        // Must have exactly one @ and it can't be at the start or end
        if (firstArroba <= 0 || firstArroba != lastArroba || firstArroba == email.length() - 1) return false;

        // 3. Disallowed characters check
        String notAllowed = "!#$%&*() ";
        for (char c : email.toCharArray()) {
            if (notAllowed.indexOf(c) != -1) return false;
        }

        // 4. Domain check (Simplified)
        String domainPart = email.substring(firstArroba + 1);
        if (!domainPart.contains(".") || domainPart.startsWith(".")) return false;

        // Optional: Check if it ends with your specific allowed domains
        boolean validEnd = false;
        String[] allowedTlds = {".com", ".br", ".net"};
        for (String tld : allowedTlds) {
            if (domainPart.endsWith(tld)) {
                validEnd = true;
                break;
            }
        }

        return validEnd;
    }




    public static void main(){
        String mail= "user@provider.com";
        System.out.println(betterIsValidmail(mail));
    }

}
