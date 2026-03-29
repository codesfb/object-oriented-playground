package br.edu.ifsp.game;

public class Game {
    private Player player1;
    private Player player2;
    private Hand[] hands = new Hand[30];
    private int currentHandIndex;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }

    public  void play(){
        if (hands[currentHandIndex] == null){
            hands[currentHandIndex]=new Hand(this.player1, this.player2);
        }
        hands[currentHandIndex].playRound();
        System.out.println(hands[currentHandIndex].farmatString());

        if(hands[currentHandIndex].isDone()){
            Player winner = hands[currentHandIndex].getWinner();
            if(winner != null){
                if(winner.getName().equals(player1.getName())) player1.incrementScore();
                else if(winner.getName().equals(player2.getName())) player2.incrementScore();
            }
        currentHandIndex++;
        }
    };

    //debug
//    public allHandswinner(){
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < currentHandIndex; i++) {
//            s
//        }
//
//    }

    public  boolean isDone(){
        return (player1.getScore() == 12 || player2.getScore() ==12);
    };


    public  Player getWinner(){

        return (player1.getScore() > player2.getScore()) ? player1: player2;
    };

    public String getScoreBoard() {
        return String.format("\n=== Placar Geral ===\n%s: %d pontos\n%s: %d pontos\nMãos encerradas: %d\n====================",
                player1.getName(), player1.getScore(),
                player2.getName(), player2.getScore(),
                currentHandIndex);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }


}
