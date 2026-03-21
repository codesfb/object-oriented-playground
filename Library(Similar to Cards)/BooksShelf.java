public class BooksShelf {
    private Book[] books;
    private int booksAmount;


    public BooksShelf() {
        this.books = new Book[10];
        this.booksAmount = 0;

    }

    public BooksShelf(Book[] collection) {
        this.books = collection;
        this.booksAmount = collection.length;

    }

    public void addBook(Book newBook) {
        if (booksAmount < books.length) {
            books[booksAmount] = newBook;
            booksAmount++;

        } else {
            System.out.println("prateleira cheia");
        }

    }

    public void showBooks() {
        System.out.println("--- Livros na Prateleira ---");
        for (int i = 0; i < this.booksAmount; i++) {
            // Usamos o this.books[i] para pegar o livro naquela posição
            System.out.println((i + 1) + ". " + this.books[i]);
        }
    }


    public Book borrowBook(String titleToFind) {
        for (int i = 0; i < this.booksAmount; i++) {
            if (this.books[i].getTitle().equals(titleToFind)) {
                if (this.books[i].isBorrowed()) {
                    this.books[i].borrow();
                    System.out.println("Sucesso! Você pegou: " + this.books[i].getTitle());
                    return this.books[i]; // Retorna o objeto livro
                } else {
                    System.out.println("O livro ta emprestado já");
                    return null;
                }
            }
        }


        System.out.println("Livro não econtrado");
        return null;
    }


}
