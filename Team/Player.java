public class Player {
    private  String name;
    private  int number;
    private String position;
    private boolean isFielded;

    public Player(String name, int number, String position){
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = false;

    }

    public String getName(){
        return this.name;
    }

    public String getStateAsString(){
        return name + " " + number + " " + position + " " + isFielded;
    }


}
