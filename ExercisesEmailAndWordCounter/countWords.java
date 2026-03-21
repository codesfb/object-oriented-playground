package fabricStaticWrappers;

public class countWords {
    public static int countWord(String phrase, String word ){
        phrase = phrase.replace(".","");
        phrase = phrase.replace(",","");
        String[] phraseWords = phrase.split(" ");
        int counter = 0;
        for(String w : phraseWords){
            if(w.equals(word)) counter++;
        }

        return counter;
    }

    static void main() {
        String phrase1 = "Talk is cheap. Show me the code.";
        String word1 = "code";
        System.out.println(countWord(phrase1,word1));//should return 1;

        String phrase2 = "code in java is fun " +
                "because java is fast and " +
                "object oriented java is amazing.";
        String word2 = "java";
        System.out.println(countWord(phrase2,word2));//should return 3;

    }
}
