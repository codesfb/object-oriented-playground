public class Team {
    private String name;
    private String baseLocation;
    private String coachName;

    public Team(String name, String baseLocation, String coachName ){
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;

    }

    /*
    *
    + addPlayer(player: Player): void
    + removePlayer(player: Player): void
    + substitute(substitute: Player, starter: Player): void
    + setCaptain(captain: Player): void
    + getFieldedPlayers(): Players[]
    + getOutfieldedPlayers(): Players[]
     */

    Player[] players = new Player[18];
    private int count = 0;
    public void addPlayer(Player player){
        if(count < 18){
            players[count] = player;
            count++;
            System.out.println(player.getName() + "successfully added ");
        }else{

            System.out.println("The team is full fool");
        }

    }
    public void removePlayer(Player player){}
    public void substitute(Player substitute, Player starter){}
    public void setCaptain(Player captain){}
    public String getFieldedPlayers(){}
    public String getOutfieldedPlayers(){}



}
