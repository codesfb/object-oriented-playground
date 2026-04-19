package PedraPapelTesoura;

public class PartidaPPT {
    //private Player winner;
    private PPT jogadaPlayer1;
    private PPT jogadaPlayer2;
    private  Player player1;
    private  Player player2;

    public PartidaPPT(Player player1, PPT jogadaPlayer1, Player player2, PPT jogadaPlayer2) {
        this.jogadaPlayer1 = jogadaPlayer1;
        this.jogadaPlayer2 = jogadaPlayer2;
        this.player1 = player1;
        this.player2 = player2;
    }

    public boolean isDone(){
        return getWinner() != null;

    }
    public Player getWinner(){
        if(jogadaPlayer1 == jogadaPlayer2 ) return null;
        if(jogadaPlayer1  == PPT.PEDRA && jogadaPlayer2 == PPT.TESOURA) return player1;
        if(jogadaPlayer1  == PPT.PAPEL && jogadaPlayer2 == PPT.TESOURA) return player2;
        if(jogadaPlayer1  == PPT.PEDRA && jogadaPlayer2 == PPT.PAPEL) return player2;
        if(jogadaPlayer1  == PPT.TESOURA && jogadaPlayer2 == PPT.PEDRA) return player2;
        if(jogadaPlayer1  == PPT.TESOURA && jogadaPlayer2 == PPT.PAPEL) return player1;
        if(jogadaPlayer1  == PPT.PAPEL && jogadaPlayer2 == PPT.PEDRA) return player1;

        return null;
    }

    @Override
    public String toString() {
        return "RodadaPPT{" +
                "jogadaPlayer1=" + jogadaPlayer1 +
                ", jogadaPlayer2=" + jogadaPlayer2 +
                ", player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }



    public PPT getJogadaPlayer1() {
        return jogadaPlayer1;
    }

    public PPT getJogadaPlayer2() {
        return jogadaPlayer2;
    }



}



