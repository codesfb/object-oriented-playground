public class MainGame {


    public static void main(String[] args) {
        Team legendsTeam = new Team("World Legends", "FIFA HQ", "Sir Alex Ferguson");
        Player p1 = new Player("Pelé",10,"Atacante");legendsTeam.setCaptain(p1);
        Player p2 = new Player("Maradona", 10, "Meia");
        Player p3 = new Player("Cruyff", 14, "Meia");
        Player p4 = new Player("Beckenbauer", 5, "Zagueiro");
        Player p5 = new Player("Lev Yashin", 1, "Goleiro");
        Player p6 = new Player("Zidane", 5, "Meia");
        Player p7 = new Player("Ronaldinho Gaúcho", 10, "Ponta");
        Player p8 = new Player("Eusébio", 13, "Atacante");
        Player p9 = new Player("Paolo Maldini", 3, "Lateral");
        Player p10 = new Player("Garrincha", 7, "Ponta");
        Player p11 = new Player("Di Stéfano", 9, "Atacante");

        Player r1 = new Player("Zico", 10, "Meia"); r1.setFielded(false);
        Player r2 = new Player("Ronaldo Fenômeno", 9, "Atacante"); r2.setFielded(false);
        Player r3 = new Player("Puskás", 10, "Atacante"); r3.setFielded(false);
        Player r4 = new Player("Roberto Carlos", 6, "Lateral"); r4.setFielded(false);
        Player r5 = new Player("Baresi", 6, "Zagueiro"); r5.setFielded(false);
        Player r6 = new Player("Platini", 10, "Meia"); r6.setFielded(false);
        Player r7 = new Player("Buffon", 1, "Goleiro"); r7.setFielded(false);
        legendsTeam.addAllTeam(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,r1,r2,r3,r4,r5,r6,r7);

        System.out.println("Teams of legends");

        System.out.println("Starters:");
        for(Player p: legendsTeam.getFieldedPlayers()){
            System.out.println(p.getStateAsString());
        }

        System.out.println("Bench:");
        for(Player p: legendsTeam.getOutFieldedPlayers()){
            System.out.println(p.getStateAsString());
        }



        Player currentCaptain = legendsTeam.getCaptain();
        if(currentCaptain!= null){
            System.out.println("Captain:"+ currentCaptain.getName());

        }


    }
}