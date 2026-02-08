import java.util.Scanner;

public class simpleMadLibs {
    static void main() {
        String verb, noun, adjective;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Verb:");
        verb = scanner.nextLine();
        System.out.print("noun:");
        noun = scanner.nextLine();
        System.out.print("adjective:");
        adjective = scanner.nextLine();



        String phrase = "The " + adjective + " student " + verb + " to the " + noun;
        System.out.println(phrase);
        scanner.close();
    }


}
