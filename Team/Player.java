public class Player {
    private  String name;
    private  int number;
    private String position;
    private boolean isFielded;
    public Player(String name, int number, String position){
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = true;

    }
    public String getName(){
        return this.name;
    }
    public boolean isFielded() {
        return this.isFielded;
    }
    public void setFielded(boolean isFielded) {
        this.isFielded = isFielded;
    }

    public String getStateAsString(){
        return name + " " + number + " " + position + " " + " | Em campo: " + (isFielded ? "Sim" : "Não");
    }


}
