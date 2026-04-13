package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;

public class Round {
    private Player winner;

    public Round(Player player1, Card card1, Player player2,Card card2, Card turnedUp) {
        int result =  card1.compareValueTo(card2, turnedUp);
        if (result > 0 ) this.winner = player1;
        if (result < 0 ) this.winner = player2;
        if (result == 0 )  this.winner = null;
    }
    @Override
    public String toString(){
        return winner == null? "empate": winner.getName();
    }

    public Player getWinner() {
        return winner;
    }
}
