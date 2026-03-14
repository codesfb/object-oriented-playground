public class Book {
    private   String  title;
    private String author;
    private boolean available;

    public Book(String title, String author){
       this.title=title;
       this.author=author;
       this.available= true;

    }

    public boolean isBorrowed(){
        return  this.available;

    }

    public void borrow() { this.available = false; }
    public void returnBook() { this.available = true; }

    public String getTitle() { return this.title; }


    @Override
    public String toString(){
        String status = this.available ? "[disponivel]" : "[Emprestado]";
        return"Título: " + this.title + " | Autor: " + this.author + " " + status;
    }

}


