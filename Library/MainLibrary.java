import java.util.Scanner;

public class MainLibrary {
    public static Book create(String title, String autor ){
         return new Book(title, autor);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //making a bookself aready full
        Book[] philosofyCollection = {
                create("O Banquete", "Platão"),
                create("Meditações", "Marco Aurélio"),
                create("Ética", "Baruch Espinosa"),
                create("Assim Falou Zaratustra", "Friedrich Nietzsche"),
                create("Crítica da Razão Pura", "Immanuel Kant"),
                create("O Mito de Sísifo", "Albert Camus"),
                create("Leviatã", "Thomas Hobbes"),
                create("Discurso do Método", "René Descartes"),
                create("Fenomenologia do Espírito", "G.W.F. Hegel"),
                create("Ser e Tempo", "Martin Heidegger")

        };

        BooksShelf philosofy = new BooksShelf(philosofyCollection);
        System.out.println("Filosofia");
        philosofy.showBooks();

        //outra prateleira
        BooksShelf ScienceFic = new BooksShelf();
        ScienceFic.addBook(create("Neuromancer", "William Gibson"));
        ScienceFic.addBook(create("Fundação", "Isaac Asimov"));
        ScienceFic.showBooks();




        //maybe we should get a books now ?;
        System.out.println("Que livro gostaria de pegar emprestado em filosofia ?");
        philosofy.borrowBook(scanner.nextLine());

        philosofy.showBooks();
        scanner.close();
    }



}
