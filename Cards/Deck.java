import java.util.Random;

public class Deck {
    private Card[] cards;
    private int cardsUsed; // Rastreia quantas cartas já foram tiradas

    public Deck() {
        this.cards = new Card[52];
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int count = 0;
        for (String s : suits) {
            for (String r : ranks) {
                cards[count++] = new Card(s, r);
            }
        }
        this.cardsUsed = 0; // Começamos com o deck cheio
        shuffle();
    }

    // Embaralha usando o algoritmo de Fisher-Yates
    public void shuffle() {
        Random rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        cardsUsed = 0; // Reinicia o deck após embaralhar
    }

    // Retira uma única carta
    public Card drawCard() {
        if (cardsUsed == cards.length) return null; // Deck vazio
        return cards[cardsUsed++]; // Retorna a carta e incrementa o contador
    }

    // Retira várias cartas
    public Card[] drawCards(int amount) {
        // Verifica se há cartas suficientes
        int available = cards.length - cardsUsed;
        int actualToDraw = Math.min(amount, available);

        Card[] hand = new Card[actualToDraw];
        for (int i = 0; i < actualToDraw; i++) {
            hand[i] = drawCard();
        }
        return hand;
    }

    public int size() {
        return cards.length - cardsUsed;
    }
}