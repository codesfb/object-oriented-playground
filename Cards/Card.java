public class Card {

    private String suit;
    private String rank;
    private boolean visible;

    public Card(String suit, String rank){
        this.suit= suit;
        this.rank= rank;
        this.visible =false;

    }

    public void flip() {
        this.visible = !this.visible;
    }

//    @Override
//    public String getStateAsString(){/// ahhh ta
//        return visible? rank + "of" + suit: "Not visible";
//
//
//    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}
