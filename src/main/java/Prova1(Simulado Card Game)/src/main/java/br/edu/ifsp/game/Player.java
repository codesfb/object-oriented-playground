package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;
public class Player {
    private String name;
    private int score;
    private Card[] cards;
    private int cardsAmount ;

    public Player(String name) {
        this.name = name;

    }
    public Card chooseCard(){
        return cards[--cardsAmount];
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
        cardsAmount= cards.length;

    }
    public void  incrementScore(){
        this.score++;

    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Card[] getCards() {
        return cards;
    }
}
