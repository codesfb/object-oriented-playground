package PedraPapelTesoura;

public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;

    }

    public void increaseScore(){
        score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
