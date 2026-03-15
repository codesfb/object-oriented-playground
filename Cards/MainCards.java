public class MainCards {
    public static void main(String[] args) {
        Deck myDeck = new Deck();

        System.out.println("Cartas no início: " + myDeck.size());

        // Distribuindo 7 cartas para dois jogadores
        Card[] hand1 = myDeck.drawCards(7);

        System.out.println("--- Mão pessoa 1 ---");
        for (Card a : hand1 ){
            a.flip(); // Revela a carta
            System.out.println(a.describeCard());
        }

        System.out.println("Cartas restantes: " + myDeck.size());
        /*
        Card[] hand2 = myDeck.drawCards(7);

        System.out.println("--- Mão pessoa 2 ---");
        for (Card a : hand2 ){
            a.flip(); // Revela a carta
            System.out.println(a);
        }
        System.out.println("Cartas restantes: " + myDeck.size());
        */


    }
}