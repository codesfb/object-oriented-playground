public class Main    {
    public static void main(String[] args) {

        // Criando usuários
        UserAccount user1 = new UserAccount("Ana", "ana@email.com");
        UserAccount user2 = new UserAccount("Bruno", "bruno@email.com");
        UserAccount user3 = new UserAccount("Carlos", "carlos@email.com");

        // Relacionamento de seguidores
        user1.acceptFollower(user2);
        user1.acceptFollower(user3);

        // user1 publica posts
        user1.publish("Nunca desista!");
        user1.publish("Foco, força e fé!");

        // Ver timeline dos seguidores
        System.out.println("=== Timeline do Bruno ===");
        System.out.println(user2.showTimeLine().equals("null") ?"vazio":user2.showTimeLine());

        System.out.println("=== Timeline do Carlos ===");
        System.out.println(user3.showTimeLine());

        // Reações (clap e boo na timeline)
        user2.clapPost(0);
        user2.clapPost(0);
        user3.booPost(1);

        // Mostrar timeline novamente (para ver alterações)
        System.out.println("=== Timeline do Bruno após claps ===");
        System.out.println(user2.showTimeLine());

        System.out.println("=== Timeline do Carlos após boo ===");
        System.out.println(user3.showTimeLine());

        // Listar posts do user1
        System.out.println("=== Posts do Ana ===");
        System.out.println(user1.showMyPosts());

        // Remover um post
        user1.delete(0);

        System.out.println("=== Posts do Ana após delete ===");
        System.out.println(user1.showMyPosts());

        // Bloquear seguidor
        user1.blockFollower(user3);

        // Novo post após bloqueio
        user1.publish("Novo post após bloqueio");

        System.out.println("=== Timeline do Bruno (deve receber) ===");
        System.out.println(user2.showTimeLine());

        System.out.println("=== Timeline do Carlos (NÃO deve receber novo post) ===");
        System.out.println(user3.showTimeLine());
    }
}