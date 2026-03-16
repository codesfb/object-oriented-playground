public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player captain;
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
            System.out.println(player.getName() + " successfully added ");
        }else{

            System.out.println("The team is full fool");
        }

    }
    public void removePlayer(Player player){
        if(players.length == 0) return;
        for(int i = 0; i < players.length; i++){
            if (players[i] != null && players[i].getName().equals(player.getName())) {
                System.out.println(player.getName() + "Removed");
                players[i] = null;
                return;
            }

        }
        System.out.println("Player not found");

    }
    public void substitute(Player substitute, Player starter){
        starter.setFielded(false);
        substitute.setFielded(true);
    }
    public void setCaptain(Player captain){
        this.captain = captain;
    }

    public Player getCaptain(){
        if (this.captain == null) {
            System.out.println("This team don't have a captain yet.");
            return null;
        }

        return this.captain;

    }
    public Player[] getFieldedPlayers(){
        int count = 0 ;
        for(Player p : this.players)
            if (p != null && p.isFielded())
                count++;


        Player[] fielded = new Player[count];

        int index = 0;
        for (Player p : this.players) {
            if (p != null && p.isFielded()) {
                fielded[index] = p;
                index++;
            }
        }
        return fielded;
    }
    public  Player[] getOutFieldedPlayers(){
        int count = 0 ;
        for(Player p : this.players)
            if (p != null && !p.isFielded())
                count++;


        Player[] Outfielder = new Player[count];

        int index = 0;
        for (Player p : this.players) {
            if (p != null && !p.isFielded()) {
                Outfielder[index] = p;
                index++;
            }
        }
        return Outfielder;

    }

    public void addAllTeam(Player... allPlayers){
        for (Player p : allPlayers) {
            this.addPlayer(p);
        }
    }


}
