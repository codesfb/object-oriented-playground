package PedraPapelTesoura;

public class RodadaPPT {
    private Player player1;
    private Player player2;
    private PartidaPPT[] patidas  = new PartidaPPT[3];
    private int vencedoresIndex;

    public RodadaPPT(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
       // this.rodada[vencedoresIndex] = getWinner();
    }
    //public boolean isDone(){}
    public void getWinner() {

    }
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
