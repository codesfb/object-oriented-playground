package fabricStaticWrappers;

public class validEmail {
    public  static boolean isValidmail(String mail) {
        for (int i = 0; i < mail.length(); i++) {
            if (mail.charAt(i) == '@' && mail.substring(mail.length() - 4).equals(".com")) {
                return true;
            }

        }
        return false;
    }

    public static void main(){
        String mail= "user@provider.com";
        System.out.println(isValidmail(mail));
    }

}
