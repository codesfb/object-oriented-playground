package br.edu.ifsp.game;

import br.edu.ifsp.deck.Card;
import br.edu.ifsp.deck.Deck;

import java.awt.font.GlyphMetrics;

public class Hand {
    private Card turnedUp;
    private Deck cards;
    private Player player1;
    private Player player2;
    private Round[] handRounds = new Round[3];
    private int roundsAmount;


    public Hand(Player player1, Player player2 ) {
        this.cards = new Deck();
        cards.shuffle();
        this.turnedUp=cards.takeOne();
        player1.setCards(cards.take(3));
        player2.setCards(cards.take(3));
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playRound(){
        Round newRound = new Round(player1, player1.chooseCard(), player2, player2.chooseCard(), turnedUp);
        handRounds[roundsAmount++] = newRound;
    }
    public boolean isDone(){
        if(roundsAmount == 3)return  true;
        return getWinner() != null;
    }

    @Override
    public String toString() {
        return "Hand{"
                 + player1.getName()  + "Jogou" + player1.getCards()[roundsAmount] +
                 player2.getName()  + "Jogou" + player2.getCards()[roundsAmount] +

                '}';
    }

    public String farmatString(){
        return String.format("carta : %s \n%s jogou %s \n%s jogou %s \nwinner da rodada: %s \nRound:%s \n",
            turnedUp, player1.getName(), player1.getCards()[roundsAmount-1],
            player2.getName(), player2.getCards()[roundsAmount-1],
            handRounds[roundsAmount-1].getWinner() == null ? "Empate" : handRounds[roundsAmount-1].getWinner().getName(),
            !isDone() ? "Em andamento" : "O round acabou " + "e o vencedor é " + getWinner().getName()
            //mostraRounds() //apenas pra debugar
        );
    }

    //debug to see who win each round
    public String mostraRounds(){
        StringBuilder sb = new StringBuilder();
        sb.append("Resultado da Rodada:").append("\n");
        for (int i = 0; i < roundsAmount; i++) {
            sb.append(i).append(": ").append(handRounds[i]).append("\n");

        }
        return sb.toString();
    }


    public Player  getWinner(){
        // Uma mão não pode ter vencedor se não jogou pelo menos 2 rodadas
        if(roundsAmount < 2) return null;
        
        Player w0 = handRounds[0].getWinner();
        Player w1 = handRounds[1].getWinner();

        // 1. Alguém ganhou as duas primeiras rodadas
        if(w0 != null && w0.equals(w1)) return w0;

        // 2. A primeira empatou (cangou) e alguém ganhou a segunda
        if(w0 == null && w1 != null) return w1;
        
        // 3. Alguém ganhou a primeira e a segunda empatou
        if(w0 != null && w1 == null) return w0;

        // 4. Chegamos na 3ª rodada (estava 1 a 1, ou as duas primeiras empataram)
        if (roundsAmount == 3) {
            Player w2 = handRounds[2].getWinner();
            
            // Se a 3ª rodada também empatar, vence quem ganhou a primeira.
            if(w2 == null) return w0;
            
            // Caso contrário, vence quem levou a 3ª rodada.
            return w2;
        }

        return null;

    }
}
