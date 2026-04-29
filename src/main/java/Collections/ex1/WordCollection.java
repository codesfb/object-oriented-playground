package Collections.ex1;
import java.util.*;

public class WordCollection {
    static void main() {
        final Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();


        String input;
        do {
            input = scanner.nextLine();
            if(!input.isEmpty())words.add(input);
        } while (!input.isEmpty());

        //print all the words
        System.out.println("All the words you just typed:");
        for(String s: words){
            System.out.printf("%s, ",  s);
        }
        System.out.println();
        System.out.println("All the words you just typed but sorted and without repetition:");
        TreeSet<String> treeSet = new TreeSet<>(words);
        for(var s: treeSet) System.out.printf("%s ",  s);

        System.out.println();
        System.out.println("Word frequency");

        TreeMap<String, Integer> freq = new TreeMap<>();
        int counter=0;
        for(String s: words){
            //returns the value of the key or 0 in case it dont exist yet
            int contagemAtual = freq.getOrDefault(s, 0);
            freq.put(s,contagemAtual+1);
        }
        freq.forEach((k,v) -> System.out.println(k+ ":"+ v));



    }
}