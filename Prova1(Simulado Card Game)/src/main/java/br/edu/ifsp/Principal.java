package br.edu.ifsp;

import br.edu.ifsp.game.Game;
import br.edu.ifsp.game.Player;

public class Principal {
    public static void main(String[] args) {
        Player palyer1 = new Player("Zé");
        Player palyer2 = new Player("Jhon");

        Game game = new Game(palyer1, palyer2);

        //jogam 12 vezes
        while(!game.isDone()) {
            game.play();
        }


        System.out.println("Pontos de "+ game.getPlayer1().getName() + " " +game.getPlayer1().getScore());
        System.out.println("Pontos de "+ game.getPlayer2().getName() + " "+ game.getPlayer2().getScore());

        System.out.println(game.getScoreBoard());
        System.out.println("O Grande Vencedor da Partida é: " + game.getWinner().getName() + "!");



    }
}
